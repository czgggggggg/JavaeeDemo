package com.bupt.request.servlet.servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author czgggggggg
 * @Date 2021/8/30
 * @Description
 */
@WebServlet("/context3")
public class ContextServlet3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        synchronized (ContextServlet3.class){
            Integer history = (Integer) servletContext.getAttribute("history");
            if(history == null){
                history = 0;
            }
            servletContext.setAttribute("history", ++history);
        }
        resp.getWriter().println("history count: " + servletContext.getAttribute("history"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
