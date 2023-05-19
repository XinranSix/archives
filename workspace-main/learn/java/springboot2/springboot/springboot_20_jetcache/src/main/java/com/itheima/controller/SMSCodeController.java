package com.itheima.controller;

import com.itheima.domain.SMSCode;
import com.itheima.service.SMSCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sms")
public class SMSCodeController {

    @Autowired
    private SMSCodeService smsCodeService;

    @GetMapping("/{tele}")
    public String getCode(@PathVariable("tele") String tele) {
        String code = smsCodeService.sendCodeToSMS(tele);
        return code;
    }

    @PostMapping
    public boolean checkCode(SMSCode smsCode) {
        return smsCodeService.checkCode(smsCode);
    }
}
