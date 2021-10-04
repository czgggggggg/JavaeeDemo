package com.bupt.fileupload.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author czgggggggg
 * @Date 2021/10/4
 * @Description
 */
@WebServlet("/upload1")
public class UploadServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //在这里面写逻辑
        //request 哪个API用来获取请求体
        ServletInputStream inputStream = req.getInputStream();
        //文件二进制数据就在inputstream中，保存到服务器。
        //图片打算保存在哪里？ web根目录下upload/目录下 upload/1.jpg
        String path = getServletContext().getRealPath("upload/1.jpg");
//        String path = getServletContext().getRealPath("upload/1.txt");
        File file = new File(path);
        if(!file.getParentFile().exists()){
            //判断当前这个1.jpg的上级目录是否存在，如果不存在则创建目录。
            file.getParentFile().mkdirs();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        int length = 0;
        byte[] bytes = new byte[1024];
        while((length = inputStream.read(bytes)) != -1){
            fileOutputStream.write(bytes,0,length);
        }
        fileOutputStream.close();
    }
}
