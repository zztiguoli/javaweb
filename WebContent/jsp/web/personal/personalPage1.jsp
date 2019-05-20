<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>完善个人信息1</title>
    
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

      	<form action="servlet/PersonalInfoProcess" method="post">
            	年龄：<input type='text' name='age'/><br>
            	性别：<input type='radio' name='gender' checked='checked' value='女'/>女
            	<input type='radio' name='gender' value='男'/>男<br>
            	家庭住址：<input type='text' name='address'/><br>
            	联系方式：<input type='text' name='tel'/><br>
            	email：<input type='text' name='email'/><br>
            	<input type='hidden' name='requestType' value='next'>
            	<input type='submit' value='下一步'>
            </form>
      </td>
      <tr>

      </table>

  </body>
</html>
