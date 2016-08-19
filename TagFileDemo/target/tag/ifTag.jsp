<%@ taglib prefix="f" uri="http://0error0warning.cn/jstl/fake" %>
<%--
  Created by IntelliJ IDEA.
  User: zhuxinquan
  Date: 16-8-16
  Time: 下午5:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>自定义if标签</title>
</head>
<body>
    <f:if test="${param.passwd == '123456'}">
        hello tld！
    </f:if>
</body>
</html>
