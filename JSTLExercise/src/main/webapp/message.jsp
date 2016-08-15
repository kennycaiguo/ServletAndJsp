<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhuxinquan
  Date: 16-8-14
  Time: 下午5:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<jsp:useBean id="messageService" class="bean.MessageService"/>
<html>
<head>
    <title>留言板</title>
</head>
<body>
    <table style="text-align: left; width: 100%;" border="1">
        <tr>
            <td>名称</td>
            <td>信息</td>
        </tr>
        <c:forEach var="message" items="${messageService.message}">
            <tr>
                <td>
                    ${message.name}
                </td>
                <td>
                    ${message.desc}
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
