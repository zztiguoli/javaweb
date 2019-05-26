<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="cn.edu.zzti.entity.AuctionDO,java.util.ArrayList,cn.edu.zzti.util.PathConstence" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品列表</title>
</head>
<body>
<table>
    <tr ><td colspan="2" align="right">
        <jsp:include page="<%=PathConstence.MANAGE_TOP%>"/>
    </td></tr>
    <tr  valign="top">
        <td width="20%">
            <jsp:include page="<%=PathConstence.MANAGE_LEFT%>"/>
        </td>
        <td align="center">
<table>
    <tr>
        <td>商品序号</td>
        <td>商品名称</td>
        <td>商品价格</td>
        <td>操作</td>
    </tr>
<%
    Object o = request.getAttribute("auctionList");
    ArrayList<AuctionDO> aucList = null;
    if(o!=null){
        aucList = (ArrayList<AuctionDO>)o;
        for (int i=0;i<aucList.size();i++){
%>
<tr>
<td><%=i+1%></td>
<td><%=aucList.get(i).getTitle()%></td>
    <td><%=aucList.get(i).getPrice()%></td>
    <td>
        <a href="<%=pageContext.getServletContext().getContextPath()+PathConstence.M_SERVLET_BASE%>/AuctionDeleteServlet?id=<%=aucList.get(i).getId()%>">删除商品</a>
        <a href="<%=pageContext.getServletContext().getContextPath()+PathConstence.M_SERVLET_BASE%>/AuctionDetailServlet?id=<%=aucList.get(i).getId()%>">修改商品</a>
    </td>
</tr>
<%
        }
    }

%>
</table>
        </td></tr></table>
</body>
</html>
