<%--
  Created by IntelliJ IDEA.
  User: zhuxinquan
  Date: 16-4-11
  Time: 下午11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>转发</title>
</head>
<body>
    <%
        String email = request.getParameter("email");
        out.println(email);
    %>
</body>
</html>
