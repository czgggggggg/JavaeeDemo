package com.bupt.servlet.path;

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
@WebServlet("/path1")
public class PathServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("name", "path");
        cookie.setPath(req.getContextPath() + "/path2");//指定当前创建的这个cookie只有在浏览器访问路径为path2的资源时，才携带。
        System.out.println("req.getContextPath() = " + req.getContextPath());
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
