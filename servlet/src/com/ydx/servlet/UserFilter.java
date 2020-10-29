package com.ydx.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ClassName UserFilter
 * @Description 描述一下该类用途
 * @Author Duxin Yuan
 * @Date 2020/10/29 17:31
 * @Version 1.0
 **/
public class UserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 过滤请求
        System.out.println("UserFilter...doFilter...");
        // 放行
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
