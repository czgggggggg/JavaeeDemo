package com.bupt.servlet.helloServlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @Author czgggggggg
 * @Date 2021/8/30
 * @Description
 */
public class LifeCycleServlet extends GenericServlet {

    /**
     * init方法默认在当前servlet第一次被访问到的时候执行
     * 第二次再次访问不会执行
     * 一个servlet默认情况下只会有一个对象
     * LifeCycleServlet默认情况下在内存中只有一个LifeCycleServlet实例化对象
     * 单例
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
//        super.init();
        System.out.println("init");
        //JDBC
    }

    /**
     * 1.服务器关闭的时候
     * 2.只关闭当前应用
     */
    @Override
    public void destroy() {
//        super.destroy();
        System.out.println("destroy");
    }

    /**
     * 每一次请求过来，都会执行service方法
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service");
        servletResponse.getWriter().println("Hello Servlet3");
        servletResponse.getWriter().println(new Date());
    }
}
