package com.ydx.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName AsyncHelloServlet
 * @Description 描述一下该类用途
 * @Author Duxin Yuan
 * @Date 2020/10/31 9:24
 * @Version 1.0
 **/
@WebServlet(value = "/async",asyncSupported = true)
public class AsyncHelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、支持异步处理，asyncSupported = true
        // 2、开启异步模式
        System.out.println(Thread.currentThread()+"主线程开始..."+System.currentTimeMillis());
        AsyncContext startAsync = req.startAsync();
        // 3、进入业务逻辑，异步处理，开始
        startAsync.start(() -> {
            try {
                System.out.println(Thread.currentThread()+"副线程开始..."+System.currentTimeMillis());
                sayHello();
                // 异步上下文
                AsyncContext asyncContext = req.getAsyncContext();
                // 响应
                ServletResponse response = asyncContext.getResponse();
                response.getWriter().write("asyncHello");
                startAsync.complete();
                System.out.println(Thread.currentThread()+"副线程结束.."+System.currentTimeMillis());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        System.out.println(Thread.currentThread()+"主线程结束..."+System.currentTimeMillis());
    }

    public void sayHello() throws InterruptedException {
        System.out.println(Thread.currentThread()+"processing...");
        Thread.sleep(3000);
    }
}
