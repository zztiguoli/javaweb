<%@ page language="java" import="java.util.*,cn.edu.zzti.util.PathConstence" pageEncoding="utf-8"%>
<table>
<tr>
	<td><a href="<%=pageContext.getServletContext().getContextPath()+PathConstence.W_SERVLET_BASE%>/GetPsersonalServlet">个人中心</a></td>
</tr>

<tr>
	<td><a href="<%=pageContext.getServletContext().getContextPath()+PathConstence.W_SERVLET_BASE%>/AuctionListServlet">全部商品</a></td>
</tr>
<tr>
	<td><a href="<%=pageContext.getServletContext().getContextPath()+PathConstence.W_SERVLET_BASE%>/CartListServlet">我的购物车</a></td>
</tr>

</table>