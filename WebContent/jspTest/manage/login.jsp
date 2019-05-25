<%--
  Created by IntelliJ IDEA.
  User: guoli
  Date: 2019-05-22
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>使用java代码实现的登录页面</title>
</head>
<body>
<form action="<%=application.getContextPath()%>/servlet/LoginServlet?type=2" method="post">
<table>
    <%
        if(request.getParameter("error")!=null) {
            %>

    <tr >
        <td colspan = "2" ><span style = "color: #a52a2a; " ><%=request.getParameter("error")%></span > </td >
    </tr >
    <%
        }%>
    <tr>
        <td>用户名</td>
        <td><input type="text" name="username"></td>
    </tr>
    <tr>
        <td>密码</td>
        <td><input type="password" name="password"></td>
    </tr>
    <tr><td colspan="2"><input type="submit" value="登录"></td></tr>
</table>
</form>
</body>
</html>
