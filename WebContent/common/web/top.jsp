<%@ page language="java"  pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
前端商城欢迎您,<c:out value="${user.username}" escapeXml="false" ><a href="<%=pageContext.getServletContext().getContextPath() %>/web/login.jsp">请登录</a> </c:out>