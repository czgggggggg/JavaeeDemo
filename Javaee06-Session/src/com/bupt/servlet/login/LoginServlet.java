package com.bupt.servlet.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author czgggggggg
 * @Date 2021/10/7
 * @Description
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //正规操作是到数据库JDBC
        if(("czgbyer".equals(username) && "123456".equals(password))
                || ("czgggggggg".equals(username) && "123456789".equals(password))){
            HttpSession session = req.getSession();
            session.setAttribute("username",username);
            resp.getWriter().println("登录成功，即将跳转到个人主页！");
            resp.setHeader("refresh","2;url=" + req.getContextPath() + "/info");
        }
    }
}
