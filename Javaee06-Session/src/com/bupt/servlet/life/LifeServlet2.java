package com.bupt.servlet.life;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author czgggggggg
 * @Date 2021/10/7
 * @Description
 */
@WebServlet("/life2")
public class LifeServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        System.out.println("session = " + session);
        System.out.println("id = " + session.getId());
        System.out.println("key = " + session.getAttribute("key"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
//session = org.apache.catalina.session.StandardSessionFacade@15588b63
//id = 5C84FDD5211933F497CE0C01C11CBD8F
//key = life

//session = org.apache.catalina.session.StandardSessionFacade@629277f5
//id = C44DEA61A156AFC5189F36CFD7ADD9A6
//key = null


//session = org.apache.catalina.session.StandardSessionFacade@4ec9fc6f
//id = 5281F6C0F5F302C732BFA352AD4D55AD
//key = life

//session = org.apache.catalina.session.StandardSessionFacade@1de8262f
//id = 5281F6C0F5F302C732BFA352AD4D55AD
//key = life