<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhuxinquan
  Date: 16-8-21
  Time: 上午8:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<jsp:useBean id="db" class="jdbc.DatabaseBean"/>
<html>
<head>
    <title>测试数据库链接</title>
</head>
<body>
    <c:choose>
        <c:when test="${db.connectedOK}">连接成功</c:when>
        <c:otherwise>连接失败</c:otherwise>
    </c:choose>
</body>
</html>
