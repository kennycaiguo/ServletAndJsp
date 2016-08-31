<%--
  Created by IntelliJ IDEA.
  User: zhuxinquan
  Date: 16-8-30
  Time: 下午8:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登陆页面</title>
</head>
<body>
    <form action="/login.do" method="post">
        账号：<input name="userName" type="text"><br>
        密码：<input name="userPassword" type="password"><br>
        <input type="submit" value="登录">
    </form>
</body>
</html>
