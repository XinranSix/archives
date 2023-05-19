package com.yupi.usercenter.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户注册请求体
 *
 * @author yaojie
 */
@Data
public class UserRegisterRequest implements Serializable {

    private static final long serialVersionUID = -6903241795004046926L;
    private String userAccount;
    private String userPassword;
    private String checkPassword;
}
