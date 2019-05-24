<%@ page language="java"  pageEncoding="utf-8"%>
<jsp:useBean id="user" class="cn.edu.zzti.entity.UserDO" scope="session"></jsp:useBean>
当前登录的用户是：<jsp:getProperty property="username" name="user"/>,
登录的时间是：<jsp:getProperty property="loginTime" name="user"/><br/>