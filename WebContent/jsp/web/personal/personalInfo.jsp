<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ page import="cn.edu.zzti.entity.PersonalInfoDO" %>
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
    	<jsp:include page="/common/manage/top.jsp"/>

    </td></tr>
    <tr  valign="top">
    <td width="20%">
    	<%@include file="/common/manage/left.jspf" %>
    </td>
    <td align="center">

    	<%
    	Object o= request.getAttribute("personalInfo");
    	
    	if(o!=null){
    		
    	
    	%>
    	<jsp:useBean id="personalInfo" class="cn.edu.zzti.entity.PersonalInfoDO" scope="request"></jsp:useBean>
        	<br> 年龄：<jsp:getProperty property="age" name="personalInfo" />
        	<br> 性别：<jsp:getProperty property="gender" name="personalInfo"/>
        	<br> 家庭住址：<jsp:getProperty property="address" name="personalInfo"/>
        	<br> 联系方式：<jsp:getProperty property="tel" name="personalInfo"/>
        	<br> email：<jsp:getProperty property="email" name="personalInfo"/>
        	<br> 毕业院校：<jsp:getProperty property="graduateSchool" name="personalInfo"/>
        	<br> 最高学历：<jsp:getProperty property="highestEducation" name="personalInfo"/>
        	<br> 专业方向：<jsp:getProperty property="major" name="personalInfo"/>
        	<%
    	}else{
        	%>
        	您还没有完善信息，<a href="personal/personalPage1.jsp">请完善信息</a>
        	<%
    	}
        	%>
    </td>
    <tr>

    </table>



</body>
</html>
