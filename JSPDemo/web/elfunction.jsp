<%@ taglib prefix="Util" uri="http://openhome.cc/Util" %>
<%--
  Created by IntelliJ IDEA.
  User: zhuxinquan
  Date: 16-5-22
  Time: 下午3:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>自定义EL函数</title>
</head>
<body>
    ${Util:length(requestScope.someList)}
</body>
</html>
