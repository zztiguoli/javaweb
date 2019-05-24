<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    buffer="8kb"
    autoFlush="true"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.getParameter("test");
	//这是一个java注释
	//System.out.print("demo....");
	out.write("这是使用JSPWriter输出的第一句话");
	response.getWriter().write("这是response.getWriter()输出的一句话");
	
	//四个作用域的使用：
	pageContext.setAttribute("data", "page");
	request.setAttribute("data", "request");
	session.setAttribute("data", "session");
	application.setAttribute("data", "application");
	
%>
<%--这是一个JSP注释 --%>
<!-- 这是一个HTML注释 ，他属于模板元素的一部分，和标签应该是一种翻译方式-->
表达式的方式获取数据：
page作用域下的data数据：<%=pageContext.getAttribute("data") %><br/>
request作用域下的data数据：<%=request.getAttribute("data") %><br/>
session作用域下的data数据：<%=session.getAttribute("data") %><br/>
application作用域下的data数据：<%=application.getAttribute("data") %><br/>

通过pageContext指定域获取数据：<br/>
<%=pageContext.getAttribute("data", PageContext.SESSION_SCOPE)%>

进行页面跳转<br/>
<%
	request.getRequestDispatcher("for.jsp").forward(request, response);
	pageContext.forward("for.jsp");
%>











</body>
</html>