package com.bupt.response.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author czgggggggg
 * @Date 2021/9/2
 * @Description
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if("admin".equals(username) && "admin".equals(password)){
            resp.getWriter().println("3秒后跳转到北邮人主页...");
            resp.setHeader("refresh","3;url=" + req.getContextPath() + "/byer.html");
            return;
        }
        resp.getWriter().println("用户名或密码错误，登录失败！");
        resp.getWriter().println("3秒后重新跳转到登录页面...");
        resp.setHeader("refresh","3;url=" + req.getContextPath() + "/login.html");
    }
}
