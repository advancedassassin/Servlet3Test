package com.ydx.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName HelloServlet
 * @Description 描述一下该类用途
 * @Author Duxin Yuan
 * @Date 2020/10/29 14:09
 * @Version 1.0
 **/
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    // 重写doGet方法
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        System.out.println(Thread.currentThread()+"start...");
        try {
            sayHello();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        resp.getWriter().write("hello");
        System.out.println(Thread.currentThread()+"end...");
    }

    public void sayHello() throws InterruptedException {
        System.out.println(Thread.currentThread()+"processing...");
        Thread.sleep(3000);
    }
}
