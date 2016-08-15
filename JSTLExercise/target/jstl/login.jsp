<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<%--
  Created by IntelliJ IDEA.
  User: zhuxinquan
  Date: 16-8-11
  Time: 上午10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆页面</title>
</head>
<body>
<c:if test="${param.name == 'admin' && param.passwd == '1234'}">
    <h1>${ param.name } 登陆成功 </h1>
</c:if>
</body>
</html>
