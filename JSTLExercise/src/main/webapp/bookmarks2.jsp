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
    <c:import var="xml" url="bookmarks.xml" charEncoding="UTF-8"/>
    <c:import var="xslt" url="${param.xslt}" charEncoding="UTF-8"/>
    <x:parse var="bookmarks" doc="${xml}"/>
    <x:transform doc="${xml}" xslt="${xslt}">
        <x:param name="headline" value="在线书签"/>
    </x:transform>
</body>
</html>
