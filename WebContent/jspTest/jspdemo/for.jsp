<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ page import="java.util.Date" %>
 <%@ page import="java.text.DateFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

	<%
		for(int i=0;i<3;i++){
			out.print(i + "<br/>");
		}
	int n = 5;
	//用for循环生成一个含有n行3列的table
	
	%>
	<table border="1">
	<% 
	for(int i=0;i<n;i++){
		out.print("<tr><td>1</td><td>2</td><td>3</td></tr>");
	}
	%>
	</table>
	
	<table border="1">
	<%for(int i=0;i<n;i++){ %>
		<tr><td>1</td><td>2</td><td>3</td></tr>
	<%} %>
	</table>
	
	当前的系统时间：
	<%
		Date d = new Date();
		//out.print(DateFormat.getDateTimeInstance().format(d));
	%>
	<%=DateFormat.getDateTimeInstance().format(d) %>
	<%!
	//JSP声明：声明一个整数countA初始化为0
	int countA = 0;%>
	<%
		//Java Scriptlet脚本，声明一个整数countB初始化为0
		int countB = 0;
	%>
	<%="countA=" + ++countA %><br/>
	<%="countB=" + ++countB %><br/>
	
	
	
	
	
	
	
	
	
	
</body>
</html>