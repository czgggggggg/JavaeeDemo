package com.bupt.servlet.servletConfig;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author czgggggggg
 * @Date 2021/8/30
 * @Description
 */
public class ConfigServlet extends HttpServlet {
    /**
     * 在当前servlet被加载的时候，tomcat会自动地将servlet节点下的init-param节点，里面的数据封装到config对象中
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        //这一步对于我们在service方法中获取初始化参数至关重要
//        super.init(config);  //测试了下注释掉调用父类方法，效果一样。Why？
        String name = config.getInitParameter("name");
        System.out.println("name = " + name);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("ConfigServlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("ConfigServlet");
    }
}
