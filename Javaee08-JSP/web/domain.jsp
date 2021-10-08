<%--
  Created by IntelliJ IDEA.
  User: 12102
  Date: 2021/10/8
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        pageContext.setAttribute("key","page");
        pageContext.setAttribute("key","request",PageContext.REQUEST_SCOPE);
    %>
    <%=pageContext.getAttribute("key")%>
    <%=request.getAttribute("key")%>
</body>
</html>
