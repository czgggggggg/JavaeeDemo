package com.bupt.fileupload.servlet;

import com.bupt.fileupload.bean.User;
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
import java.util.Iterator;
import java.util.List;

/**
 * 将数据封装到User
 * @Author czgggggggg
 * @Date 2021/10/4
 * @Description
 */
@WebServlet("/upload4")
public class UploadServlet4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //是否包含上传文件
        boolean result = ServletFileUpload.isMultipartContent(req);
        if(!result)
            return;//不包含上传文件，直接return。

        User user = new User();//////
        //工厂模式DruidDataSourceFactory
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletContext servletContext = this.getServletContext();
        File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
        factory.setRepository(repository);
        ServletFileUpload upload = new ServletFileUpload(factory);
        //如果文件名乱码，需要设置这个
        upload.setHeaderEncoding("utf-8");
        try {
            List<FileItem> fileItems = upload.parseRequest(req);
            Iterator<FileItem> iterator = fileItems.iterator();
            while(iterator.hasNext()){
                FileItem item = iterator.next();
                if(item.isFormField())//是否是普通的表单数据
                    //user//////
                    processFormField(item,user);//////
                else
                    //user//////
                    processUploadedFile(item,user);//////
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }

    /**
     * 处理form表单数据的具体业务逻辑
     */
    private void processFormField(FileItem item, User user){//////
        String fieldName = item.getFieldName();
        String value = null;
        try {
            value = item.getString("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //可以，中规中矩的方式//////
        if("username".equals(fieldName))//////
            user.setUsername(value);//////
        else if("password".equals(fieldName))//////
            user.setPassword(value);//////
        System.out.println(fieldName + " = " + value);
    }

    /**
     * 处理上传的文件业务逻辑
     */
    private void processUploadedFile(FileItem item, User user){//////
        String fieldName = item.getFieldName();
        String filename = item.getName();
        System.out.println("fieldName = " + fieldName);
        System.out.println("filename = " + filename);

        //保存到服务器磁盘上
        String basePath = "upload/" + filename;//////
        String path = getServletContext().getRealPath(basePath);//////
        System.out.println("path = " + path);
        File file = new File(path);
        if(!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        try {
            item.write(file);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //显示的，保存相对路径//////
        user.setImage(basePath);//////
    }
}
