package com.tomgiova.springinterceptor.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter
public class LoginModel {
    private String username;
    private String password;
}
