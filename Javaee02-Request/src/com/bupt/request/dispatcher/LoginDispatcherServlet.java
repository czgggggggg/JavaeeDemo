package com.bupt.request.dispatcher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author czgggggggg
 * @Date 2021/9/1
 * @Description
 */
@WebServlet("/loginDispatcher")
public class LoginDispatcherServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //拿到用户名和密码，校验
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //JDBC
        //dbutils  QueryRunner run = new QueryRunner(datasource)
        //run.query(select * from user where username = ? and password = ?, new BeanHandler, param)
        //模拟
        if("admin".equals(username) && "admin".equals(password)){
            //用户名和密码校验正确，则跳转到个人主页
            //参数表示的是目标组件info.html
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("info.html");
            //执行转发操作
            requestDispatcher.forward(req,resp);

        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("get");
    }
}
