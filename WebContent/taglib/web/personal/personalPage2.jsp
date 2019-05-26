<%@ page language='java' import='java.util.*' pageEncoding='utf-8'%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN'>
<html>
  <head>
    <base href='<%=basePath%>'>
    
    <title>完善个人信息2</title>
    
	<meta http-equiv='pragma' content='no-cache'>
	<meta http-equiv='cache-control' content='no-cache'>
	<meta http-equiv='expires' content='0'>    
	<meta http-equiv='keywords' content='keyword1,keyword2,keyword3'>
	<meta http-equiv='description' content='This is my page'>
	<!--
	<link rel='stylesheet' type='text/css' href='styles.css'>
	-->

  </head>
  
  <body>
     <table>
        <tr ><td colspan="2" align="right">
        	<jsp:include page="${pageContext.servletContext.contextPath}/common/web/top.jsp"/>

        </td></tr>
        <tr  valign="top">
        <td width="20%">
        	<%@include file="/common/web/left.jspf" %>
        </td>
        <td align="center">

        	 <form action="servlet/PersonalInfoProcess" method="post">
				 <table><tr><td>
                	最高学历：</td><td>
                	<select name='highestEducation'>
                		<option value='学士'>学士</option>
                		<option value='硕士'>硕士</option>
                		<option value='博士'>博士</option>
                		<option value='其他'>其他</option>
                	</select></td></tr>
					 <tr><td>毕业院校：</td><td><select name='graduateSchool'>
                		<option value='北京大学'>北京大学</option>
                		<option value='清华大学'>清华大学</option>
                		<option value='其他院校'>其他院校</option>
                	</select></td></tr>
					 <tr><td>所学专业：</td><td><<input type='text' name='major'/></td></tr>
					 <tr><td colspan="2" align="right"><input type='hidden' name='requestType' value='save'>
						 <input type='submit' value='保存'></td></tr>
				 </table>
                </form>
        </td>
        <tr>

        </table>

  </body>
</html>
