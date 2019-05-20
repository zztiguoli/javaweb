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
      	<jsp:include page="/common/web/top.jsp"/>

      </td></tr>
      <tr  valign="top">
      <td width="20%">
      	<%@include file="/common/web/left.jspf" %>
      </td>
      <td align="center">

      	<form action="servlet/PersonalInfoProcess" method="post">
            <table>
                <tr><td>年龄：</td><td><input type='text' name='age'/></td></tr>
                <tr><td>年性别：</td><td><input type='radio' name='gender' checked='checked' value='女'/>女
            	<input type='radio' name='gender' value='男'/>男</td></tr>
                <tr><td>年家庭住址：</td><td><input type='text' name='address'/></td></tr>
                <tr><td>年联系方式：</td><td><input type='text' name='tel'/></td></tr>
                <tr><td>年email：</td><td><<input type='text' name='email'/></td></tr>
                <tr><td colspan="2" align="right"><input type='hidden' name='requestType' value='next'>
            	<input type='submit' value='下一步'></td></tr>
            </table>
            </form>
      </td>
      <tr>

      </table>

  </body>
</html>
