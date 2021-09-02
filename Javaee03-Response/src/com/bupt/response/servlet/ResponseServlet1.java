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
@WebServlet("/response1")
public class ResponseServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        resp.setStatus(200);
//        resp.setStatus(404);

        //设置响应体的编码格式  //无效，浏览器中显示的还是乱码。
//        resp.setCharacterEncoding("utf-8");
//        resp.getWriter().println("我是北邮人");

        //该响应头表示两层含义：
        //1.设置响应体的编码格式为utf-8
        //2.同时发送一个content-type的响应头，这里面告诉浏览器服务端使用的编码格式
//        resp.setHeader("content-type","text/html;charset=utf-8");
//        resp.getWriter().println("我是北邮人");  //有效，浏览器中中文显示正常。

        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println("我是北邮人");  //有效，浏览器中中文显示正常。

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
