package com.lemon.wje.unils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.lemon.wje.entity.User;
import org.apache.logging.log4j.util.Strings;

import java.util.Calendar;

public class JWTUtils {

    /**
     * 获取 token
     *
     * @param u
     * @return 生成的 token
     */
    public static String getToken(User u) {
        Calendar instance = Calendar.getInstance();
        //默认令牌过期时间7天
        instance.add(Calendar.DATE, 7);

        JWTCreator.Builder builder = JWT.create();
        builder.withClaim("username", u.getUsername())
                .withClaim("password", u.getPassword());

        return builder.withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256(u.getPassword()));
    }

    /**
     * 验证 token 合法性
     *
     * @param token
     * @return
     */
    public static DecodedJWT verify(String token) {
        if (Strings.isEmpty(token)) {
            throw new RuntimeException("token 不能为空");
        }
        String password = "admin";
        JWTVerifier build = JWT.require(Algorithm.HMAC256(password)).build();
        return build.verify(token);
    }

}
