package com.bupt.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @Author czgggggggg
 * @Date 2021/10/5
 * @Description
 */
@WebServlet("/lastlogin")
public class LastLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //显示用户上次的访问时间 为什么不用date.toString这种形式呢？
        //如何来显示 cookie头里面的数据取出来 request.getHeader
        Cookie[] cookies = req.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                if("lastLogin".equals(cookie.getName())){
                    String value = cookie.getValue();
                    resp.getWriter().println(new Date(Long.parseLong(value)));
                }
            }
        }
        Cookie cookie = new Cookie("lastLogin", System.currentTimeMillis() + "");
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
