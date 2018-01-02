package com.yangcl.ec.api.erp.common;

import com.yangcl.ec.api.erp.service.authentication.AuthService;
import com.yangcl.ec.common.entity.common.LoginAccount;
import com.yangcl.ec.common.entity.erp.domain.Permission;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private AuthService authService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws Exception{
        if(handler.getClass().isAssignableFrom(HandlerMethod.class)){
            AuthPassport authPassport=((HandlerMethod)handler).getMethodAnnotation(AuthPassport.class);

            //没有声明需要权限，或者声明不验证权限
            if(authPassport==null || authPassport.validate()==false){
                return true;
            }else{
                boolean isAuth=false;
                String token=request.getHeader("Authorization");
                if(token==null){
                    isAuth=false;
                }else{

                    //解决拦截器注入不进service问题，手动注入
                    if(authService==null){
                        BeanFactory factory= WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
                        authService=(AuthService)factory.getBean(AuthService.class);
                    }

                    LoginAccount loginAccount=authService.getAccountByToken(token);
                    if(loginAccount!=null && loginAccount.getPermissions()!=null){
                        String url=request.getRequestURI().substring(request.getContextPath().length());
                        if(url.startsWith("/") && url.length()>1){
                            url=url.substring(1);
                        }
                        for(String s:loginAccount.getPermissions()){
                            if(s!=null && s.equals("/"+url)){
                                isAuth=true;
                            }
                        }
                    }
                }
                if(isAuth){
                    return true;
                }else{
                    response.setContentType("application/json;charset=UTF-8");
                    PrintWriter out=response.getWriter();
                    out.write("{\"code\":\"402\",\"message\":\"没有权限\"}");
                    out.close();
                    return false;
                }
            }
        }else{
            return true;
        }
    }
}
