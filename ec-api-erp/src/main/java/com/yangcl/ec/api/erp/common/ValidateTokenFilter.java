package com.yangcl.ec.api.erp.common;

import com.netflix.ribbon.proxy.annotation.Http;
import com.yangcl.ec.api.erp.service.authentication.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Order(1)
@WebFilter(filterName = "ValidateTokenFilter",urlPatterns = "/system/*")
public class ValidateTokenFilter implements Filter {

    @Autowired
    private AuthService authService;

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        String token=request.getHeader("Authorization");
        if(token!=null){
            Boolean isAuth=authService.validateToken(token);
            if(isAuth){
                filterChain.doFilter(servletRequest,servletResponse);
            }
        }
    }

    public void destroy() {
    }
}
