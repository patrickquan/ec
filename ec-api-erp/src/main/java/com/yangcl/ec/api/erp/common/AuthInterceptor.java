package com.yangcl.ec.api.erp.common;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws Exception{
        if(handler.getClass().isAssignableFrom(HandlerMethod.class)){
            AuthPassport authPassport=((HandlerMethod)handler).getMethodAnnotation(AuthPassport.class);

            //没有声明需要权限，或者声明不验证权限
            if(authPassport==null || authPassport.validate()==false){
                return true;
            }else{
                //这里实现自己的权限验证逻辑
                if(false){
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
