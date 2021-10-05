package com.bupt.fileupload.servlet;

import com.alibaba.druid.pool.DruidDataSource;
import com.bupt.fileupload.bean.Product;
import com.bupt.fileupload.bean.User;
import com.bupt.fileupload.utils.DruidUtils;
import com.bupt.fileupload.utils.FileUploadUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * @Author czgggggggg
 * @Date 2021/10/4
 * @Description
 */
@WebServlet("/upload7")
public class UploadServlet7 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //中文乱码的解决
        resp.setContentType("text/html;charset=utf-8");

        //是否包含上传文件
        boolean result = ServletFileUpload.isMultipartContent(req);
        if(!result)
            return;//不包含上传文件，直接return。

        User user = new User();//////
        HashMap<String,Object> resultMap = FileUploadUtils.parseRequest(req);
//        Product product = new Product();
        try {
            BeanUtils.populate(user,resultMap);
//            BeanUtils.populate(product,resultMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println("user = " + user);
//        System.out.println("product = " + product);

        //----------------------------------------//
        //接着就是数据库那一套
        //数据库的包 mysql-connector-java druid dbutils
        QueryRunner runner = new QueryRunner(DruidUtils.getDataSource());//QueryRunner()中传入datasource则connection不用自己关，反之需要自己关。
        try {
            runner.update("insert into user values (null,?,?,?)",
                    user.getUsername(),
                    user.getPassword(),
                    user.getImage());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.getWriter().println("注册成功");

        //----------------------------------------//
    }
}
