package com.bupt.fileupload.servlet;

import com.bupt.fileupload.bean.Product;
import com.bupt.fileupload.utils.FileUploadUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/**
 * @Author czgggggggg
 * @Date 2021/10/4
 * @Description
 */
@WebServlet
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap<String, Object> hashMap = FileUploadUtils.parseRequest(req);
        Product product = new Product();
        try {
            BeanUtils.populate(product,hashMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println("product = " + product);
    }
}
