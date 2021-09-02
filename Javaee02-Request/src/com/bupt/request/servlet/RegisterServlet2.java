package com.bupt.request.servlet;

import com.bupt.request.bean.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * @Author czgggggggg
 * @Date 2021/9/2
 * @Description
 */
@WebServlet("/register2")
public class RegisterServlet2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Enumeration<String> parameterNames = req.getParameterNames();
//        while (parameterNames.hasMoreElements()){
//            String key = parameterNames.nextElement();
//            String value = req.getParameter(key);//页面提交的checkbox参数，只能获取到一个
//            System.out.println(key + " = " + value);
//            String[] values = req.getParameterValues(key);
//            System.out.println(key + " = " + Arrays.toString(values));
//        }
        //需要将这些参数全部封装到user对象中
        //使用一个第三方的jar包来帮助我们完成
        //将第二个map里面的参数迭代出来，封装到第一个参数对象中
        User user = new User();
        req.setCharacterEncoding("utf-8");
        try {
            BeanUtils.populate(user,req.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println("user = " + user);//控制台输出可能还是乱码，但是此时已经解决乱码问题，该乱码的原因是因为操作系统使用的是GBK，Debug调试不显示乱码。
    }
}
