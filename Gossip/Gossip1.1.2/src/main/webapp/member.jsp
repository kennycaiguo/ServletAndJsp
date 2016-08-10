<%@ page import="model.UserService" %>
<%@ page import="model.Blah" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: zhuxinquan
  Date: 16-8-10
  Time: 上午8:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String username = (String) request.getSession().getAttribute("login");
    if(username == null){
        request.setAttribute("error", "请先进行登陆");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
%>
<html>
<head>
    <link rel="stylesheet" href="css/member.css" type="text/css">
    <title>Gossip 微博</title>
</head>
<body>
<div class="leftPanel">
    <img src="images/caterpillar.jpg" alt="Gossip 微博"/>
    <br><br>
    注销<a href="logout.do?username=<%= username %>" style="color: #89c272;"><%= username %>></a>
</div>
<form method="post" action="message.do">
    分享新鲜事……<br>
    <%
        String blabla = request.getParameter("blabla");
        if(blabla == null){
            blabla = "";
        } else {
    %>
    信息要在140字以内<br>
    <%
        }
    %>
    <textarea cols='60' rows='4' name='blabla'><%= blabla %></textarea><br>
    <button type="submit">送出</button>
</form>
<table style='text-align: left; width: 510px; height: 88px;' border='0' cellpadding='2' cellspacing='2'>
    <thead>
    <tr>
        <th><hr></th>
    </tr>
    </thead>
    <tbody>
    <%
        UserService userService = (UserService) pageContext.getServletContext().getAttribute("userService");
        System.out.println(userService);
        List<Blah> messages = userService.readMessage(username);
        for(Blah blah : messages){
    %>
        <tr>
            <td style="vertical-align: top">
                <%= blah.getUsername() %>
                <%= blah.getDate() %><br>
                <%= blah.getTxt()%><br>
                <%
                    if(username.equals(blah.getUsername())){
                %>
                <a href="delete.do?message=<%= blah.getId() %>" style="color: #89c272">删除</a>
                <%
                    }
                %>
                <hr>
            </td>
        </tr>
    <%
        }
    %>
    </tbody>
</table>
<hr style="width: 100%; height: 1px;">
</body>
</html>
