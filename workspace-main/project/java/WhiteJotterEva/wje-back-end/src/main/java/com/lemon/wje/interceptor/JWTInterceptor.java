package com.lemon.wje.interceptor;

import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.lemon.wje.unils.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class JWTInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");

        if (Strings.isEmpty(token)) {
            throw new RuntimeException("token 不能为空");
        }
        try {
            JWTUtils.verify(token);
        } catch (SignatureVerificationException e) {
            log.error("无效签名！错误 ->", e);
            return false;
        } catch (TokenExpiredException e) {
            log.error("token 过期！错误 -> ", e);
            return false;
        } catch (AbstractMethodError e) {
            log.error("token 算法不一致！错误 -> ", e);
            return false;
        } catch (Exception e) {
            log.error("token 无效！错误 ->", e);
            return false;
        }
        return true;
    }
}
