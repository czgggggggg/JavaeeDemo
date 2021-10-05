package com.bupt.fileupload.servlet;

import com.bupt.fileupload.bean.User;
import com.bupt.fileupload.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author czgggggggg
 * @Date 2021/10/5
 * @Description
 */
@WebServlet("/info")
public class InfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        QueryRunner runner = new QueryRunner(DruidUtils.getDataSource());
        //ResultHandler----  BeanListHandler  BeanHandler
        List<User> users = null;
        try {
            users = runner.query("select * from user", new BeanListHandler<User>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.getWriter().println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>");
        for(User user : users){
            resp.getWriter().println("<div>" + user.getUsername() + "</div>");
            resp.getWriter().println("<div>" + user.getPassword() + "</div>");
            resp.getWriter().println("<image src='" + req.getContextPath() + user.getImage() + "'/>");
        }
        resp.getWriter().println("</body>\n" +
                "</html>");
    }
}
