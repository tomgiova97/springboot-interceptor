package com.tomgiova.springinterceptor.services;

import com.tomgiova.springinterceptor.utils.LoginModel;

public interface AuthenticationService {
    public boolean isAuthenticationTokenValid(String token) throws Exception;

    public String generateToken(LoginModel loginModel);
}
