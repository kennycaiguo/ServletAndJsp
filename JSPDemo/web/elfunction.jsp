<%@ page import="java.util.Collection" %>
<%@ page import="java.util.LinkedList" %>
<%@ taglib prefix="Util" uri="http://cc.openhome.Util" %>
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
<%
    Collection<String> c = new LinkedList<>();
    c.add("123");
    c.add("456");
%>
    ${ Util:length(c) }
</body>
</html>
