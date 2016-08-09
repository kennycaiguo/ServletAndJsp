<%--
  Created by IntelliJ IDEA.
  User: zhuxinquan
  Date: 16-4-12
  Time: 下午8:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>session</title>
</head>
<body>
    <%
        String name = (String)session.getAttribute("user");
        out.print(name);
    %>
</body>
</html>
