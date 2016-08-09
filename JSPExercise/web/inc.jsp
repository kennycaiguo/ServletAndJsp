<%--
  Created by IntelliJ IDEA.
  User: zhuxinquan
  Date: 16-4-11
  Time: 下午11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>inc</title>
</head>
<body>
    <%-- 被包含的页面中获取传递的参数 --%>
    <%
        out.println("hello");
        String value = request.getParameter("name");
        out.println("<br>" + value);
    %>

</body>
</html>
