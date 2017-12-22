package com.yangcl.ec.service.authentication.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    //会员登录
    @RequestMapping(value ="/member",method = RequestMethod.POST,consumes = "application/json")
    public String memberLogin(String username,String password){
        return "";
    }

    //ERP登录
    @RequestMapping(value = "/erp",method = RequestMethod.POST,consumes = "application/json")
    public String erpLogin(String username,String password){
        return "";
    }
}
