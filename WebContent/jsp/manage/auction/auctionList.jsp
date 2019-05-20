<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="cn.edu.zzti.entity.AuctionDO" %>
<%@ page import="cn.edu.zzti.entity.AuctionDO" %>
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
    	<jsp:include page="/common/manage/top.jsp"/>
    	
    </td></tr>
    <tr  valign="top">
    <td width="20%">
    	<%@include file="/common/manage/left.jspf" %>
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
    	<%
    	Object o = request.getAttribute("auctionList");
    	if(o!=null){
    		List<AuctionDO> list = (List<AuctionDO>)o;
    		for(int i=0;i<list.size();i++){
    	%>
		    	<tr>
		    		<td><%= list.get(i).getId() %></td>
		    		<td><%= list.get(i).getTitle() %></td>
		    		<td><%= list.get(i).getDescription() %></td>
		    		<td><%= list.get(i).getPrice() %></td>
		    		<td><a href="<%=pageContext.getServletContext().getContextPath()%>/manage/AuctionDetailServlet?id=<%= list.get(i).getId() %>">修改</a>&nbsp;
						<a href="<%=pageContext.getServletContext().getContextPath()%>/manage/AuctionDeleteServlet?id=<%= list.get(i).getId() %>">删除</a></td>
		    	</tr>
    	<%
    		}
    	}
    	%>
    	</table>
    </td>
    <tr>
    
    </table>
  </body>
</html>
