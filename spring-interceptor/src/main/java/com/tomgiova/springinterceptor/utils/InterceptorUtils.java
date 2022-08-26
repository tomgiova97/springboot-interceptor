package com.tomgiova.springinterceptor.utils;

import java.util.*;

public class InterceptorUtils {

    public static String extractBearerToken (String bearerToken) {
        return bearerToken.replaceAll("Bearer ","");
    }

    public static List<Map<String,String>> unprotectedURIs(){
        String authenticationPath = "/authentication";
        Map<String,String> loginURI = Collections
                .singletonMap("POST", authenticationPath + "/login");
        Map<String,String> logoutURI = Collections
                .singletonMap("POST", authenticationPath + "/logout");
        Map<String,String> verifyTokenURI = Collections
                .singletonMap("POST", authenticationPath + "/token");
        return new ArrayList<>(Arrays.asList(loginURI,logoutURI,verifyTokenURI));
    }

    public static void printMapsList (List<Map<String,String>> mapsList) {
        for (Map<String,String> map : mapsList) {
            System.out.print(map.keySet().stream().findFirst().get());
            System.out.print(" ");
            System.out.println(map.values().stream().findFirst().get());
        }
    }

    public static boolean isUriUnprotected(Map<String,String> uri) {
        return unprotectedURIs().contains(uri);
    }
}
