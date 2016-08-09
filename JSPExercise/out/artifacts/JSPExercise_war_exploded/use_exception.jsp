<%--
  Created by IntelliJ IDEA.
  User: zhuxinquan
  Date: 16-4-14
  Time: 下午11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    int[] num = {1, 2, 3, 4, 5};
    for(int i = 0; i <= num.length; i++){
        out.println(num[i]);
    }
%>
</body>
</html>
