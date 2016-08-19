<%@tag description="显示错误信息的标签" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${requestScope.errors != null}">
    <h1>新增会员失败</h1>
    <ul style="color: red">
        <c:forEach var="error" items="${requestScope.errors}">
            <li>${error}</li>
        </c:forEach>
    </ul>
</c:if>