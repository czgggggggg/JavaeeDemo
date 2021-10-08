<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 12102
  Date: 2021/10/8
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
1.jsp
    <%=new Date()%>
    <%
        //hello
        System.out.println("hello," + name);
        for(int i = 0; i < 10; i++){

    %>
    <div style="color:red">hello world</div>
    <%
        }
    %>

    <%!
        //hello
        String name = "czgbyer";
    %>

    //hello //注意，这不是注释，都会被打印出来。
    <%--jsp注释是写在骨架元素中的，空白区域的--%>
    <!--这种注释是啥（html注释）-->
</body>
</html>


<!--
控制台输出：
hello,czgbyer
-->
<!--
浏览器输出：
1.jsp Fri Oct 08 10:52:58 CST 2021
hello world
hello world
hello world
hello world
hello world
hello world
hello world
hello world
hello world
hello world
//hello //注意，这不是注释，都会被打印出来。
-->