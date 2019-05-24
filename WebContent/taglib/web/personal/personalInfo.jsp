<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>个人基本信息展示</title>

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
    	<jsp:include page="/WebContent/common/web/top.jsp"/>

    </td></tr>
    <tr  valign="top">
    <td width="20%">
    	<%@include file="/WebContent/common/web/left.jspf" %>
    </td>
    <td align="center">
    <c:choose>

		<c:when test="${empty personalInfo  }">
			您还没有完善信息，<a href="personal/personalPage1.jsp">请完善信息</a>
		</c:when>
		<c:otherwise>
			<table>
				<tr>
					<td>年龄：</td>
					<td>${personalInfo.age }</td>
				</tr>
				<tr>
					<td>性别：</td>
					<td>${personalInfo.gender }</td>
				</tr>
				<tr>
					<td>家庭住址：</td>
					<td>${personalInfo.address }</td>
				</tr>
				<tr>
					<td>联系方式：</td>
					<td>${personalInfo.tel }</td>
				</tr>
				<tr>
					<td>email：</td>
					<td>${personalInfo.email }</td>
				</tr>
				<tr>
					<td>毕业院校：</td>
					<td>${personalInfo.graduateSchool }</td>
				</tr>
				<tr>
					<td>最高学历：</td>
					<td>${personalInfo.highestEducation }</td>
				</tr>
				<tr>
					<td>专业方向：</td>
					<td>${personalInfo.major }</td>
				</tr>

			</table>
		</c:otherwise>
	</c:choose>

    </td>
    <tr>

    </table>



</body>
</html>
