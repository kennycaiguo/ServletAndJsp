<%@ page import="java.util.LinkedList" %><%--
  Created by IntelliJ IDEA.
  User: zhuxinquan
  Date: 16-5-19
  Time: 下午1:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="util" uri="http://localhost:8080/JSPExercise/ELexercise/Util" %>
<html>
<head>
    <title>自定义EL函数</title>
</head>
<body>
    ${util:length(requestScope.someList)}
</body>
</html>
