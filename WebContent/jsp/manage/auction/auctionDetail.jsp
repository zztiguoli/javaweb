<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>商品详情</title>
    
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
        <%
            Object o= request.getAttribute("auctionDO");

            if(o!=null){


        %>
        <jsp:useBean id="auctionDO" class="cn.edu.zzti.entity.AuctionDO" scope="request"></jsp:useBean>
        <form action="<%=pageContext.getServletContext().getContextPath()%>/manage/AuctionUpdateServlet" method="POST">
            <table>
                <tr>
                    <td>商品标题</td>
                    <td><input type="text" name="title" size="60" value="<%=auctionDO.getTitle()%>"/>
                        <input type="hidden" name="id" size="60" value="<%=auctionDO.getId()%>"/>
                    </td>
                </tr>
                <tr>
                    <td>商品简介</td>
                    <td><textarea name="auctionDescription" cols="60" rows="20"><%=auctionDO.getDescription()%></textarea></td>
                </tr>
                <tr>
                    <td>商品价格</td>
                    <td><input type="text" name="price" value="<%=auctionDO.getPrice()%>"/>元</td>
                </tr>
                <tr>
                    <td colspan="2" align="right"><input type="submit" value="保存商品"/></td>
                </tr>
            </table>
        </form>
        <%
        }else{
        %>
        商品不存在，<a href="manage/AuctionListServlet">回首页</a>
        <%
            }
        %>
    </td>
    <tr>
    
    </table>
  </body>
</html>
