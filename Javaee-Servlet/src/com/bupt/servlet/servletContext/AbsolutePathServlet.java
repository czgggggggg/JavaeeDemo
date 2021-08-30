package com.bupt.servlet.servletContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * @Author czgggggggg
 * @Date 2021/8/30
 * @Description
 */
@WebServlet("/path")
public class AbsolutePathServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //应用内web根目录下有一个1.html，获取到该文件的file信息
        File file = new File("1.html");
        System.out.println(file.exists());//false
        System.out.println(file.getAbsolutePath());//D:\softwareforcode\apache-tomcat-8.5.54-windows-x64\apache-tomcat-8.5.54\bin\1.html
        //realPath就是我们的最终部署目录的根目录
        //可以获取WEB-INF目录下的文件 屏蔽的是浏览器
        String realPath1 = getServletContext().getRealPath("WEB-INF");
        System.out.println(realPath1);//D:\IDEAProjects\JavaeeDemo\out\artifacts\Javaee_Servlet_war_exploded\WEB-INF
        String realPath2 = getServletContext().getRealPath("1.html");
        File file1 = new File(realPath2);
        System.out.println(file1.exists());//true
        System.out.println(file1.getAbsolutePath());//D:\IDEAProjects\JavaeeDemo\out\artifacts\Javaee_Servlet_war_exploded\1.html
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
