package com.yupi.usercenter.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户登录请求体
 *
 * @author yaojie
 */
@Data
public class UserLoginRequest implements Serializable {

    private static final long serialVersionUID = -6903241795004046926L;
    private String userAccount;
    private String userPassword;
}
