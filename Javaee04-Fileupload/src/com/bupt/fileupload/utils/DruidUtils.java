package com.bupt.fileupload.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author czgggggggg
 * @Date 2021/10/4
 * @Description
 */
public class DruidUtils {
    private static DataSource dataSource;

    static{
        //要用类加载器的一个API来获取绝对路径，可以和servletContext解耦
        // c3p0-config.xml文件放在哪的？ src目录 不需要做任何配置，它就可以读取到
        InputStream inputStream = DruidUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        Properties properties = new Properties();

        try {
            properties.load(inputStream);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource(){
        return dataSource;
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
