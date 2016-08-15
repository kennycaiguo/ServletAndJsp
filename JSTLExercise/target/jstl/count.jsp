<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhuxinquan
  Date: 16-8-15
  Time: 下午12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<c:set var="count" value="${sessionScope.count + 1}" scope="session"/>
<html>
<head>
    <title>JSP Count</title>
</head>
<body>
    <h1>JSP Count ${sessionScope.count}</h1>
    <a href="<c:url value='count.jsp'/>">递增</a>
</body>
</html>