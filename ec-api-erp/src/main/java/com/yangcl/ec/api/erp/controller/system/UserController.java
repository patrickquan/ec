package com.yangcl.ec.api.erp.controller.system;

import com.yangcl.ec.api.erp.common.AuthPassport;
import com.yangcl.ec.api.erp.service.authentication.AuthService;
import com.yangcl.ec.api.erp.service.erp.UserService;
import com.yangcl.ec.common.entity.erp.domain.Role;
import com.yangcl.ec.common.entity.erp.domain.User;
import com.yangcl.ec.common.entity.common.JsonResult;
import com.yangcl.ec.common.entity.common.LoginAccount;
import com.yangcl.ec.common.entity.erp.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//@CrossOrigin(origins = "http://localhost:8080",maxAge = 3600)
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;

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

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(@RequestParam(value = "token",required = false) String token){
        if(token==null)
            token=authService.createToken(new HashMap<String,Object>());

        Boolean isToken=authService.validateToken(token);

        return isToken.toString();
    }

    //@AuthPassport
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public JsonResult<UserDto> userLogin(@RequestBody User user){
        if(user==null || user.getLoginName()==null || user.getLoginName()==""){
            return new JsonResult<UserDto>("401","帐号不能为空！");
        }
        if(user==null || user.getLoginPwd()==null || user.getLoginPwd()==""){
            return new JsonResult<UserDto>("401","密码不能为空！");
        }

        User result=userService.getByUsernameAndPassword(user.getLoginName(),user.getLoginPwd());


        if(result==null){
            return new JsonResult<UserDto>("401","帐号或密码错误，登录失败！");
        }else{
            //创建DTO对象
            UserDto userDto=new UserDto();
            userDto.setUserId(result.getSysno().toString());
            userDto.setUserName(result.getEmployee().getEmployeeName());
            userDto.setLoginName(result.getLoginName());
            userDto.setMenus(result.getRoles());
            //创建token
            LoginAccount loginAccount=new LoginAccount();
            loginAccount.setAccountId(result.getSysno().toString());
            loginAccount.setAccountName(result.getEmployee().getEmployeeName());
            loginAccount.setOtherName("");
            loginAccount.setPassword("");
            loginAccount.setSysName("erp");
            loginAccount.setUsername(result.getLoginName());
            loginAccount.setPermissions(result.getPermissionStringList());

            LoginAccount loginResult=authService.createToken(loginAccount);
            userDto.setToken(loginResult.getToken());
            return new JsonResult<UserDto>("200","登录成功！",loginResult.getToken(),userDto);
        }
    }
}
