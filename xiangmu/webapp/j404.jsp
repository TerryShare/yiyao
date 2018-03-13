<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>消失在宇宙星空中的404页面</title>
<link href="images/jq22.css" rel="stylesheet" type="text/css" />
</head>
<body>
<!-- 代码 开始 -->
<div class="fullScreen" id="fullScreen">
    <a href="#" class="logo"><img src="images/homepage-logo.png"></a>
    <img class="rotating" src="images/spaceman.svg" />
    <div class="pagenotfound-text">
    <h1>Page lost in space</h1>
    <h2><a href="#">Go back to the homepage</a></h2>
    </div>
    <canvas id="canvas2d"></canvas>
</div>
<script type="text/javascript" src="images/jq22.js"></script>
<!-- 代码 结束 -->


</body>
</html>