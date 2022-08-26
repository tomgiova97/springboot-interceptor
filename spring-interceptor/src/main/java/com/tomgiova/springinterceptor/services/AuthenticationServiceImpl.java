package com.tomgiova.springinterceptor.services;

import com.tomgiova.springinterceptor.utils.LoginModel;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AuthenticationServiceImpl implements AuthenticationService{

    private final String SECRET = "demoSecret"; //put here your JWT secret

    @Override
    public boolean isAuthenticationTokenValid(String token) throws Exception{

        //Check in the db if the token exist

        //Get the user associated with that token

        //If (user == null) ---> throw TokenNotValidException

        //If (token.isExpired) ---> throw TokenExpiredException

        return false;
    }

    @Override
    public String generateToken(LoginModel loginModel) {
        final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(loginModel.getUsername() + loginModel.getPassword() + SECRET);
    }

}
