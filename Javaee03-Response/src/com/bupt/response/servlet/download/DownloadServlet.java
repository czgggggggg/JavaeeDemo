package com.bupt.response.servlet.download;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author czgggggggg
 * @Date 2021/10/5
 * @Description
 */
@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-Disposition","attachment;filename=1.jpg");
        //当我访问http://localhost:8080/image的时候
        //将web根目录下的1.jpg内容显示在浏览器正文中
        //通过刚刚的抓包，那么文本文件的二进制数据应当写入响应体中
        String path = getServletContext().getRealPath("1.jpg");
//        String path = getServletContext().getRealPath("/WEB-INF/2.jpg");
        File file = new File(path);
        FileInputStream fileInputStream = new FileInputStream(file);
        //需要有一个输出流，将file信息写入到response体中
        ServletOutputStream outputStream = resp.getOutputStream();
        byte[] bytes = new byte[1024];
        int length = 0;
        while((length = fileInputStream.read(bytes)) != -1){
            outputStream.write(bytes,0,length);
        }
        //关闭流 response的输出流，你可以关闭，也可以不关闭
        //在响应结束以后，tomcat会帮我们关闭
        fileInputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
