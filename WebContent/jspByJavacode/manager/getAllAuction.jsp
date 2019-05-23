<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="cn.edu.zzti.entity.AuctionDO,java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品列表</title>
</head>
<body>
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
    <td><a href="">查看详情</a>
        <a href="">删除商品</a>
        <a href="">修改商品</a>
    </td>
</tr>
<%
        }
    }

%>
</table>
</body>
</html>
