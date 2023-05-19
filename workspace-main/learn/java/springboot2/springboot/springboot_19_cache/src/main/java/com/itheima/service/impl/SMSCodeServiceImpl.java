package com.itheima.service.impl;

import com.itheima.domain.SMSCode;
import com.itheima.service.SMSCodeService;
import com.itheima.utils.CodeUtils;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeoutException;

@Service
public class SMSCodeServiceImpl implements SMSCodeService {

    @Autowired
    CodeUtils codeUtils;

//    @Override
//    // @Cacheable(value = "smsCode", key = "#tele")
//    @CachePut(value = "smsCode", key = "#tele")
//    public String sendCodeToSMS(String tele) {
//        // String code = codeUtils.generator(tele);
//        return codeUtils.generator(tele);
//    }
//
//    @Override
//    public boolean checkCode(SMSCode smsCode) {
//        String code = smsCode.getCode();
//        String cacheCode = codeUtils.get(smsCode.getTele());
//        return code.equals(cacheCode);
//    }

    @Autowired
    MemcachedClient memcachedClient;

    @Override
    public String sendCodeToSMS(String tele) {
        String code = codeUtils.generator(tele);
        try {
            memcachedClient.set(tele, 0, code);
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MemcachedException e) {
            e.printStackTrace();
        }
        return code;
    }

    @Override
    public boolean checkCode(SMSCode smsCode) {
        String code = null;
        try {
            code = memcachedClient.get(smsCode.getTele()).toString();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MemcachedException e) {
            throw new RuntimeException(e);
        }
        return smsCode.getCode().equals(code);
    }
}
