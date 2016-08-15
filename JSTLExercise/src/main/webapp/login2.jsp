<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" import="bean.User" %>
<%--
  Created by IntelliJ IDEA.
  User: zhuxinquan
  Date: 16-8-11
  Time: 下午12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="user" class="bean.User" />
<jsp:setProperty name="user" property="*"/>

<html>
<head>
    <title>登录失败</title>
</head>
<body>
<c:choose>
    <c:when test="${user.valid}">
        <h1>
            <jsp:getProperty name="user" property="name"/>登录成功
        </h1>
    </c:when>
    <c:otherwise>
        <h1>登录失败</h1>
    </c:otherwise>
</c:choose>
</body>
</html>
