package com.yangcl.ec.api.erp.service.authentication;

import org.springframework.stereotype.Component;

@Component
public class LoginServiceHystrix implements LoginService {
    @Override
    public String memberLogin(String username, String password) {
        return "error";
    }

    @Override
    public String erpLogin(String username, String password) {
        return "error";
    }
}
