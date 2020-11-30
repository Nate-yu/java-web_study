package com.example.session.login;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Nate yu
 * @date 2020/11/10 - 19:48:05
 * @Description TODO
 */
@Data
public class User implements Serializable {
    private String username;
    private String password;
}
