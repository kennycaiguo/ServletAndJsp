<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>send mail~</title>
</head>
<body>

<%--<form method="post" action="/mail2.do" enctype="multipart/form-data">--%>
<form method="post" action="/mail.do" enctype="application/x-www-form-urlencoded">
    <input type="submit" value="send"><br/>
    发件人：<input type="text" name="from"><br/>
    收件人：<input type="text" name="to"><br/>
    主题：<input type="text" name="subject"><br/><br/>
    <%--附件：<input type="file" name="file"/><br/>--%>
    <textarea type="text" name="text"></textarea>
</form>

</body>
</html>
