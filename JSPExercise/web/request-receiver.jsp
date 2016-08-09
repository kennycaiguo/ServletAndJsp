<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //获取请求数据
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;charset=UTF-8");
    response.setCharacterEncoding("UTF-8");
    String user  = request.getParameter("user");
    String passwd = request.getParameter("passwd");
    System.out.println(user + " " + passwd);
    if("xb".equals(user) && "123".equals(passwd)) {
//        out.println("登录成功");
        session.setAttribute("user", user);
        System.out.println(session.getId());
        response.sendRedirect("success-session.jsp");
    }else {
        out.println("error");
    }
%>