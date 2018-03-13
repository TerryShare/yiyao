<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>用户查看</title>
<link rel="stylesheet" href="res/css/bootstrap.css">
<script type="text/javascript" src="res/js/jquery.min.js"></script>
<script type="text/javascript" src="res/js/bootstrap.min.js"></script>
</head>
<body>
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px; padding-left: 20px;">
			<li>系统管理</li>
			<li>用户管理</li>
			<li>查看用户</li>
		</ul>
	</div>
	<form action="" method="post" class="form-horizontal">
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px">用户基本信息</h5>
		<div class="row">
<!-- 隐藏域 -->

			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">用户姓名</label>
					<div class="col-sm-9">
						   <p class="form-control-static">${dcUser_Info.user_name }</p>
					</div>
				</div>
			</div>
			<input type="hidden" name="User_id" value="${dcUser_Info.user_id }">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">用户性别</label>
					<div class="col-sm-5">
					 <p class="form-control-static">${dcUser_Info.user_sex }</p>
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">用户年龄</label>
					<div class="col-sm-9">
				 <p class="form-control-static">${dcUser_Info.user_age }</p>
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">薪资</label>
					<div class="col-sm-9">
						 <p class="form-control-static">${dcUser_Info.user_salary }</p>
					</div>
				</div>
			</div>
		</div>
			<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px">账号信息</h5>
			<div class="row">
					<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">用户账号</label>
					<div class="col-sm-9">
						 <p class="form-control-static">${dcUser_Info.user_account }</p>
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">用户密码</label>
					<div class="col-sm-9">
				 <p class="form-control-static">${dcUser_Info.user_password }</p>
					</div>
				</div>
			</div>
			
			</div>
		<div class="row">
			<div class="col-sm-10" align="center">
				<a href="user/dancha.do?User_id=${dcUser_Info.user_id }&pd=1&mhcx=${mhcx}"  class="btn btn-primary">修改用户信息</a> <a
					href="user/findAll.do?mhcx=${mhcx}" class="btn btn-danger">返回上一级</a>
			</div>
		</div>
	</form>

</body>
</html>