<%--
  Created by IntelliJ IDEA.
  User: guoli
  Date: 17/7/6
  Time: 下午5:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <title>我的购物车</title>
</head>

<body>

<table>
    <tr ><td colspan="2" align="right">
        <jsp:include page="/WebContent/common/web/top.jsp"/>

    </td></tr>
    <tr  valign="top">
        <td width="20%">
            <%@include file="/WebContent/common/web/left.jspf" %>
        </td>
        <td align="center">

            <form action="" method="post">
                <table border="1">
                    <tr>
                        <td colspan="7" align="center">我的购物车</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>商品编号</td>
                        <td>商品名称</td>
                        <td>商品数量</td>
                        <td>商品单价</td>
                        <td>商品总价</td>
                        <td>操作列表</td>
                    </tr>
                    <c:forEach items="${cartList}" var="cart">
                        <tr>
                            <td><input type="checkbox" name="slctedOrder" value="${cart.auctionDO.id}"></td>
                            <td>${cart.auctionDO.id}</td>
                            <td>${cart.auctionDO.title}</td>
                            <td>${cart.number}</td>
                            <td>${cart.auctionDO.price}</td>
                            <td>${cart.totlePrice}</td>
                            <td><a href="${pageContext.servletContext.contextPath}/web/RemoveCartServlet?id=${cart.auctionDO.id}">删除此商品</a></td>
                        </tr>

                    </c:forEach>
                    <tr>
                        <td colspan="7" align="right"><a href="${pageContext.servletContext.contextPath}/web/getAllAuction">继续购物</a></td>
                    </tr>
                </table>
            </form>
        </td>
    <tr>

</table>


</body>
</html>
