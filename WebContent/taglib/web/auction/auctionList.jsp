<%@ page language="java"  pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>商品列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <table>
    <tr ><td colspan="2" align="right">
    	<jsp:include page="${pageContext.servletContext.contextPath}/common/web/top.jsp"/>
    	
    </td></tr>
    <tr  valign="top">
    <td width="20%">
    	<%@include file="/common/web/left.jspf" %>
    </td>
    <td align="center">
    
    	<table border="1" >
    	<tr>
    		<td>商品编号</td>
    		<td>商品标题</td>
    		<td>商品描述</td>
    		<td>商品价格</td>
    		<td></td>
    	</tr>
			<c:forEach items="${auctionList }" var="auction" begin="0" step="1">
				<tr>
					<td>${auction.id }</td>
					<td>${auction.title }</td>
					<td>${auction.description }</td>
					<td>${auction.price }</td>
					<td><a href="${pageContext.servletContext.contextPath}/web/AddCartServlet?id=${auction.id }">加入购物车</a>
				</tr>
			</c:forEach>
    	</table>
    </td>
    <tr>
    
    </table>
  </body>
</html>
