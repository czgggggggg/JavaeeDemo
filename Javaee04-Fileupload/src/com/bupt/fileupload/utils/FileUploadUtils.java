package com.bupt.fileupload.utils;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/**
 * @Author czgggggggg
 * @Date 2021/10/4
 * @Description
 */
public class FileUploadUtils {
    private static final String BASE_PATH = "/upload";//////////////////

    public static HashMap<String, Object> parseRequest(HttpServletRequest req) {
        HashMap<String,Object> resultMap = new HashMap<>();//不传入User，而是传入一个Map。////////////
        //工厂模式DruidDataSourceFactory
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletContext servletContext = req.getServletContext();
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
                    processFormField(item,resultMap);////////////
                else
                    //user//////
                    processUploadedFile(item,req,resultMap);////////////
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        return resultMap;
    }

    /**
     * 处理form表单数据的具体业务逻辑
     */
    private static void processFormField(FileItem item, HashMap<String, Object> map){//////
        String fieldName = item.getFieldName();
        String value = null;
        try {
            value = item.getString("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
//        //可以，中规中矩的方式//////
//        if("username".equals(fieldName))//////
//            user.setUsername(value);//////
//        else if("password".equals(fieldName))//////
//            user.setPassword(value);//////
        map.put(fieldName,value);////////////
        System.out.println(fieldName + " = " + value);
    }

    /**
     * 处理上传的文件业务逻辑
     */
    private static void processUploadedFile(FileItem item, HttpServletRequest req, HashMap<String, Object> map){//////
        String fieldName = item.getFieldName();
        String filename = item.getName();
        System.out.println("fieldName = " + fieldName);
        System.out.println("filename = " + filename);

        //保存到服务器磁盘上
        //-------------------------------------------------------
        //哈希值的特点：散列 31 乘子
        //其他方式完全ok
        filename = UUID.randomUUID() + "-" + filename;//UUID.randomUUID()随机生成一个字符串//解决同一个目录下出现多个同名文件的问题。
        int code = filename.hashCode();
        //8位16进制  1 /2 /3 /8 /9 /a /f /1 /filename
        //           16*16*16*16*16*16*16*16/ 寥寥无几的几个文件
        String hexString = Integer.toHexString(code);
        char[] chars = hexString.toCharArray();
        String prefix = BASE_PATH;
        for(char c : chars){
            prefix = prefix + "/" + c;
        }
        String basePath = prefix + "/" + filename;//////////////////
        //-------------------------------------------------------
//        String basePath = "upload/" + filename;//////
        String path = req.getServletContext().getRealPath(basePath);//////
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
//        user.setImage(basePath);//////
        map.put(fieldName,basePath);////////////
    }
}
