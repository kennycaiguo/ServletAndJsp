<%--
  Created by IntelliJ IDEA.
  User: zhuxinquan
  Date: 16-4-12
  Time: 下午7:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="request-receiver.jsp">
        <input type="text" name="user"/><br>
        <input type="password" name="passwd"/><br>

        <input type="submit" value="登录"/>
    </form>
    <%
        request.getContextPath();
        String path = application.getContextPath();
        out.println(path);
    %>
</body>
</html>
