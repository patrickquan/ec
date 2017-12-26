package com.yangcl.ec.api.erp.controller.system;

import com.yangcl.ec.api.erp.service.authentication.LoginService;
import com.yangcl.ec.api.erp.service.erp.UserService;
import com.yangcl.ec.common.entity.erp.User;
import com.yangcl.ec.common.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080",maxAge = 3600)
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login2",method = RequestMethod.POST)
    public JsonResult<User> userLogin(@RequestParam(value = "loginname",required = false) String loginName,
                                @RequestParam(value = "loginpwd",required = false) String loginPwd){
        if(loginName==null || loginName==""){
            return new JsonResult<User>("401","帐号不能为空！");
        }
        if(loginPwd==null || loginPwd==""){
            return new JsonResult<User>("401","密码不能为空！");
        }

        User user=userService.getByUsernameAndPassword(loginName,loginPwd);
        if(user==null){
            return new JsonResult<User>("401","帐号或密码错误，登录失败！");
        }else{
            return new JsonResult<User>("200","登录成功！",user);
        }
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public JsonResult<User> userLogin(@RequestBody User user){
        if(user==null || user.getLoginName()==null || user.getLoginName()==""){
            return new JsonResult<User>("401","帐号不能为空！");
        }
        if(user==null || user.getLoginPwd()==null || user.getLoginPwd()==""){
            return new JsonResult<User>("401","密码不能为空！");
        }

        User result=userService.getByUsernameAndPassword(user.getLoginName(),user.getLoginPwd());
        if(result==null){
            return new JsonResult<User>("401","帐号或密码错误，登录失败！");
        }else{
            return new JsonResult<User>("200","登录成功！",result);
        }
    }
}
