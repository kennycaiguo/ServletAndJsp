<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhuxinquan
  Date: 16-8-15
  Time: 下午12:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add page</title>
</head>
<body>
    <c:catch var="error">
        ${param.a} + ${param.b} = ${param.a + param.b}
    </c:catch>
    <c:if test="${error != null}">
        <br><span style="color: red;">${error.message}</span>
        <br>${error}
    </c:if>
</body>
</html>
