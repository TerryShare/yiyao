<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>报销单</title>
<link rel="stylesheet" href="res/css/bootstrap.css">
<script type="text/javascript" src="res/js/jquery.min.js"></script>
<script type="text/javascript" src="res/js/bootstrap.min.js"></script>

</head>
<body>
<form action="user/fasong.do" method="post" class="form-horizontal">

	<center>
		<table>
			<tr>
				<td>发件人:  ${youjian.fjrxm }</td>
			</tr>
			<tr>
				<td>主题:  ${youjian.zhuti }</td>
			</tr>
			<tr>
				<td>内容:  ${youjian.neirong }</td>
			</tr>
		</table>
	</center>
	
	<h3>回信</h3>
	<center>
	<input type="hidden" name="shoujianrenid" value="${youjian.fajianrenid }">
	<input type="hidden" name="id" value="${youjian.id }">
		<table>
			
			<tr>
				<td>主题: </td>
				<td><input type="text" name="zhuti"></td>
			</tr>
			<tr>
				<td>内容: </td>
				<td><input type="text" name="neirong"></td>
			</tr>
		</table>
		<input type="submit" value="发送">
	</center>
</form>
</body>
</html>