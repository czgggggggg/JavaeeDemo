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
@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //方式一：
//        resp.setStatus(302);//状态一定要写
////        resp.setHeader("Location","www.baidu.com");//不正确的姿势，url会重定向到http://localhost:8080/response/www.baidu.com
//        resp.setHeader("Location","http://www.baidu.com");//这才是正确的姿势

        //方式二：
        resp.sendRedirect("http://www.baidu.com");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
