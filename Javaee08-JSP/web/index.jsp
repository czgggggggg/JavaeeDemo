<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 12102
  Date: 2021/10/8
  Time: 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
      hello world!
      <%=new Date()%>
      <%
        System.out.println("hello jsp!");
        response.getWriter().println("jsp脚本片段");
      %>
  </body>
</html>
