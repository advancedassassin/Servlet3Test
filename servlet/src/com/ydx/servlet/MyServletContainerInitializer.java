package com.ydx.servlet;

import com.ydx.service.HelloService;

import javax.servlet.*;
import javax.servlet.annotation.HandlesTypes;
import java.util.EnumSet;
import java.util.Set;

/**
 * @ClassName MyServletContainerIn
 * @Description 描述一下该类用途
 * @Author Duxin Yuan
 * @Date 2020/10/29 16:56
 * @Version 1.0
 **/
@HandlesTypes(value = {HelloService.class})
public class MyServletContainerInitializer implements ServletContainerInitializer {
    /**
     * @author Duxin Yuan
     * @description //应用启动时候会运行该方法
     * @date 2020/10/29 17:05
     * @param set
     * @param servletContext 当前应用的ServletContext，一个Web应用对应一个ServletContext；四大域对象之一
     * @return void
     **/
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {

        for(Class claz : set){
            System.out.println("感兴趣的类"+claz);
        }
        // 注册组件
        ServletRegistration.Dynamic userServlet = servletContext.addServlet("userServlet", new UserServlet());
        // 配置Servlet映射
        userServlet.addMapping("/user");

        servletContext.addListener(UserListener.class);

        FilterRegistration.Dynamic userFilter = servletContext.addFilter("userFilter", UserFilter.class);
        // 配置Filter映射
        userFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST),true, "/*");
    }
}
