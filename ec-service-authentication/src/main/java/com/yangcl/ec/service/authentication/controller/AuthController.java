package com.yangcl.ec.service.authentication.controller;

import com.yangcl.ec.common.entity.erp.Permission;
import com.yangcl.ec.service.authentication.common.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value = "/auth/token/create",method = RequestMethod.POST)
    public String createToken(@RequestBody Map<String,Object> claims){
        String token=jwtUtil.createdToken(claims);
        return token;
    }

    /**
     * 验证token
     * @param token
     * @return
     */
    @RequestMapping(value = "/auth/token/validate",method = RequestMethod.POST)
    public Boolean validateToken(@RequestBody String token){
        return jwtUtil.validateToken(token);
    }

    /**
     * 获取自定义值
     * @param token
     * @param key
     * @return
     */
    @RequestMapping(value = "/auth/token/value",method = RequestMethod.POST)
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
