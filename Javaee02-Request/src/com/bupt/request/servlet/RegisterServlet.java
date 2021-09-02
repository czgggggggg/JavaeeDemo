package com.bupt.request.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * @Author czgggggggg
 * @Date 2021/9/1
 * @Description
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取前端的请求参数 假设页面中的属性有很多 能不能精简一下呢
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//        String gender = req.getParameter("gender");
//        String hobby = req.getParameter("hobby");
//        System.out.println("username = " + username);
//        System.out.println("password = " + password);
//        System.out.println("gender = " + gender);
//        System.out.println("hobby = " + hobby);

        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String key = parameterNames.nextElement();
            String value = req.getParameter(key);//页面提交的checkbox参数，只能获取到一个
            System.out.println(key + " = " + value);
            String[] values = req.getParameterValues(key);
            System.out.println(key + " = " + Arrays.toString(values));
        }
    }
}
