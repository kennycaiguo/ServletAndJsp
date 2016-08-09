<%@ page import="com.zxq.Person" %><%--
  Created by IntelliJ IDEA.
  User: zhuxinquan
  Date: 16-4-11
  Time: 下午11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>包含页面</title>
  </head>
  <body>
    <h1>包含页面</h1>
    <jsp:include page="inc.jsp">
      <jsp:param name="name" value="value"></jsp:param>
    </jsp:include>
    <form action="received.jsp">
      <input type="text" name="email">
      <input type="submit" value="提交">
    </form>

    <h1>useBean动作元素</h1>
    <%--创建对象  调用默认的构造方法，要求类必须有默认的构造方法--%>
  <jsp:useBean id="person" class="com.zxq.Person"></jsp:useBean>
  <%--设置对象的属性值--%>
  <jsp:setProperty name="person" property="name" value="小白"></jsp:setProperty>
  <jsp:setProperty name="person" property="age" value="18"></jsp:setProperty>
  <%--获取对象的属性值--%>
  <jsp:getProperty name="person" property="name"></jsp:getProperty>
  <jsp:getProperty name="person" property="age"></jsp:getProperty>

  <%
    com.zxq.Person p = new Person();
    p.setName("bame");
    p.setAge(18);
  %>
  </body>
</html>
