package com.yangcl.ec.service.authentication.controller;

import com.yangcl.ec.common.entity.erp.Permission;
import com.yangcl.ec.service.authentication.common.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    /**
     * 创建token
     * @param claims
     * @return
     */
    @RequestMapping(value = "/auth/token/create",method = RequestMethod.GET)
    public String createToken(@RequestParam Map<String,Object> claims){
        String token=jwtUtil.createdToken(claims);
        return token;
    }

    /**
     * 验证token
     * @param token
     * @return
     */
    @RequestMapping(value = "/auth/token/validate",method = RequestMethod.GET)
    public Boolean validateToken(@RequestParam  String token){
        return jwtUtil.validateToken(token);
    }

    /**
     * 获取自定义值
     * @param token
     * @param key
     * @return
     */
    @RequestMapping(value = "/auth/token/value",method = RequestMethod.GET)
    public Object getValueFromToken(@RequestParam String token,@RequestParam String key){
        return jwtUtil.getValueFromToken(token,key);
    }

    @RequestMapping(value = "/test")
    public String test(){
        Map<String,Object> claims=new HashMap<String,Object>();
        claims.put("sub","admin");
        List<Permission> permissions=new ArrayList<Permission>();
        Permission p=new Permission();
        p.setPermissionName("Dashboard");
        permissions.add(p);
        p=new Permission();
        p.setPermissionName("系统管理");
        permissions.add(p);
        claims.put("permissions",permissions);
        String token=jwtUtil.createdToken(claims);

        String user=jwtUtil.getAccountFromToken(token);
        Object result=jwtUtil.getValueFromToken(token,"permissions");

        List<Permission> presult=(List<Permission>)result;

        return user;
    }
}
