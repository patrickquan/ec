package com.yangcl.ec.api.erp.controller.system;

import com.yangcl.ec.api.erp.service.authentication.LoginService;
import com.yangcl.ec.api.erp.service.erp.UserService;
import com.yangcl.ec.common.entity.erp.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login",method = RequestMethod.POST,consumes = "application/json")
    public String userLogin(String username,String password){
        return "";
    }

    @RequestMapping(value = "/get")
    public UserEntity get(){
        return userService.getByKey(1);
    }

    @RequestMapping(value = "/test")
    public String test(){
        return loginService.test();
    }
}
