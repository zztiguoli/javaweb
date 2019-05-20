<%@ page language="java"  pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<%--JSTL的错误“attribute test does not accept any expressions”解决方法

解决方法有2个

1、将<%@taglib prefix="c" uri="http://java.sun.com/jstl/core"%>更改为<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

2、使用JSTL的备用库，将<%@taglib prefix="c" uri="http://java.sun.com/jstl/core"%>

更改为<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%> --%>
前端商城欢迎您,<c:out value="${user.username}" escapeXml="false" ><a href="<%=pageContext.getServletContext().getContextPath() %>/web/login.jsp">请登录</a> </c:out>