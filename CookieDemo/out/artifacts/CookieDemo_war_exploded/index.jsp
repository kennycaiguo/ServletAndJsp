<%--
  Created by IntelliJ IDEA.
  User: zhuxinquan
  Date: 16-3-21
  Time: 下午8:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Login</title>
  </head>
  <body>
  <form method="post" action="login.do">
    <h2>会员登陆<a style="font-size: 10px " href="register.html">还不是会员？</a></h2><br><br>
    用户名:<input name="username" type="text" value=""><br>
    密码:<input style="margin-left: 16px" name="passwd" type="password" value=""><br>
    自动登陆:<input type="checkbox" name="auto" value="yes"><br>
    <input align="center" value="登陆" type="submit"><br>
    <a href="#">忘记密码？</a>
  </form>
  </body>
</html>
