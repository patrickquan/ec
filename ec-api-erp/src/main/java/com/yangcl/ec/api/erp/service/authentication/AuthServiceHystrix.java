package com.yangcl.ec.api.erp.service.authentication;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AuthServiceHystrix implements AuthService {
    public String createToken(Map<String, Object> claims) {
        return "error2";
    }

    public Boolean validateToken(String token) {
        return null;
    }

    public Object getValue(String token, String ken) {
        return null;
    }
}
