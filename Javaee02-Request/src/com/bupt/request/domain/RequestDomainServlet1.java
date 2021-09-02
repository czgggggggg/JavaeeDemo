package com.bupt.request.domain;

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
@WebServlet("/domain1")
public class RequestDomainServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //使用context域
//        getServletContext().setAttribute("key","value");

        //使用request域
        req.setAttribute("key","value");
        String val = (String) req.getAttribute("key");
        System.out.println("val = " + val);
//        req.getRequestDispatcher("domain2").forward(req,resp);
        req.getRequestDispatcher("domain2").include(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
