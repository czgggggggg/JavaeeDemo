package com.bupt.request.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author czgggggggg
 * @Date 2021/9/1
 * @Description 用来解析请求报文的各个部分
 */
@WebServlet("/parse")
public class ParseRequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //请求行
        String method = req.getMethod();
        String requestURI = req.getRequestURI();
        String requestURL = req.getRequestURL().toString();
        String protocol = req.getProtocol();
        System.out.println(method);//GET
        System.out.println(requestURI);// /parse
        System.out.println(requestURL);//http://localhost:8080/parse
        System.out.println(protocol);//HTTP/1.1
        //请求头
        String host = req.getHeader("Host");
        System.out.println(host);//localhost:8080
        //请求体
        //req.getInputStream();
        //除此之外，还提供其他丰富的API来供开发者使用
        int remotePort = req.getRemotePort();
        System.out.println(remotePort);//59291
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
