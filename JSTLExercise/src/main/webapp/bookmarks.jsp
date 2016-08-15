<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhuxinquan
  Date: 16-8-15
  Time: 下午8:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<c:import var="xml" url="./bookmarks.xml" charEncoding="UTF-8"/>
<x:parse var="bookmarks" doc="${xml}"/>
<h2>在线书签</h2>
<table border="1">
    <tr bgcolor="#00ff00">
        <th align="left">名称</th>
        <th align="left">网址</th>
        <th align="left">分类</th>
    </tr>
    <x:forEach var="bookmark" select="$bookmarks//bookmark">
        <tr>
            <td><x:out select="$bookmark/title"/></td>
            <td><x:out select="$bookmark/url"/></td>
            <td><x:out select="$bookmark/category"/></td>
        </tr>
    </x:forEach>
</table>
</body>
</html>
