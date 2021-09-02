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
@WebServlet("/path")
public class PathServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURL = req.getRequestURL().toString();
        String requestURI = req.getRequestURI();
        String contextPath = req.getContextPath();
        String servletPath = req.getServletPath();
        System.out.println(requestURL);// http://localhost:8080/response/path
        System.out.println(requestURI);// /response/path
        System.out.println(contextPath);// /response
        System.out.println(servletPath);// /path
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
