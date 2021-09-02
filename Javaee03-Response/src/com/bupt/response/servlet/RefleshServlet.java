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
@WebServlet("/refresh")
public class RefleshServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //方式一：表示经过指定秒数刷新一次
//        resp.setHeader("refresh","2");
//        resp.getWriter().println("refresh");
        //方式二：表示经过指定秒数跳转至url，结束
        //以下几种url的表达方式都是可行的。
//        resp.setHeader("refresh","2,url=login.html");
//        resp.setHeader("refresh","2,url=http://localhost:8080/response/login.html");
//        resp.setHeader("refresh","2,url=" + req.getContextPath() + "/login.html");
        resp.setHeader("refresh","2,url=/response/login.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
