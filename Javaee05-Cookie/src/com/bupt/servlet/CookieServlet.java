package com.bupt.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author czgggggggg
 * @Date 2021/10/5
 * @Description
 */
@WebServlet("/cookie1")
public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.生成cookie对象
        Cookie cookie = new Cookie("name", "czgbyer");
        //要将cookie信息以Set-Cookie响应头的形式发送回客户端。
        //这个时候response已经给你封装好了API，你直接用即可
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
