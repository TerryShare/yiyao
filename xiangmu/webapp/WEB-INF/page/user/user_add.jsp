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
<title>用户添加</title>
<link rel="stylesheet" href="res/css/bootstrap.css">
<script type="text/javascript" src="res/js/jquery.min.js"></script>
<script type="text/javascript" src="res/js/bootstrap.min.js"></script>

<!-- (*╹▽╹*) -->
<link rel="stylesheet" href="res/gj/demo.css">
<script src="https://cdn.jsdelivr.net/jquery/1.12.3/jquery.min.js"></script>
<script src="res/gj/jquery.validator.min.js?local=en"></script>

<!-- (*╹▽╹*) -->

</head>
<body>
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px; padding-left: 20px;">
			<li>系统管理</li>
			<li>用户管理</li>
			<li>添加用户</li>
		</ul>
	</div>
	<form action="user/insert.do" method="post" class="form-horizontal"
		name="form" data-validator-option="{timely:2, theme:'yellow_right_effect'}">
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px">用户基本信息</h5>
		<div class="row form-item">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">用户姓名</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" name="User_name"
							placeholder="请输入用户姓名" data-rule="required;User_name;"
							data-rule-User_name="[/^[\u4E00-\u9FA5]{3,50}$/, '请重新输入']"
							data-tip="请输入中文"
							data-msg-required="请填写姓名"
							 />
					</div>
				</div>
			</div>
			<div class="col-sm-5 form-item">
				<div class="form-group">
					<label class="col-sm-3 control-label">用户性别</label>
					<div class="col-sm-5">
						<select name="User_sex" class="form-control">
							<option>保密</option>
							<option>男</option>
							<option>女</option>
						</select>
					</div>
				</div>
			</div>


			<div class="col-sm-5 form-item">
				<div class="form-group">
					<label class="col-sm-3 control-label">角色</label>
					<div class="col-sm-5">
						<select name="Role_id" class="form-control">

							<c:forEach var="s" items="${Rolelist }">
								<option value="${s.role_id }">${s.role_name }</option>
							</c:forEach>

						</select>
					</div>
				</div>
			</div>

			<div class="col-sm-5 form-item">
				<div class="form-group">
					<label class="col-sm-3 control-label">用户年龄</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" name="User_age"
							placeholder="请输入用户年龄" 
							data-rule="required; User_age;"
							data-rule-User_age="[/^[\d]{1,2}$/, '请输入正确的年龄']"
							data-tip="请输入您的年龄" 
							data-msg-required="请填写年龄"
							/>
							
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group form-item">
					<label class="col-sm-3 control-label">薪资</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" name="User_salary"
							placeholder="请输入薪资" 
							data-rule="required; User_salary;"
							data-rule-User_salary="[/^[\d]{1,5}([.][\d]{1,3})?$/, '请输入正确的月薪']"
							data-tip="请输入月薪" 
							data-msg-required="请填写薪资"
							/>
							
					</div>
				</div>
			</div>
		</div>
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px">账号信息</h5>
		<div class="row">
			<div class="col-sm-5 form-item">
				<div class="form-group">
					<label class="col-sm-3 control-label">用户账号</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" name="User_account"
							placeholder="请输入用户账号" 
							data-rule="required; User_account;"
							data-rule-User_account="[/^[\w\d]{3,7}$/, '请输入正确的账号字母或数字']"
							data-tip="请输入您的新账号字母或数字"
							data-msg-required="请填写用户账号"
							 />
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group form-item">
					<label class="col-sm-3 control-label">用户密码</label>
					<div class="col-sm-9">
						<input type="password" class="form-control" name="User_password"
							placeholder="请输入用户密码" 
							data-rule="required;User_password;"
							data-rule-User_password="[/^[\w\d]{3,7}$/, '请用数字或字母']"
							data-tip="请输入您密码" 
							data-msg-required="请填写用户密码"
							/>
					</div>
				</div>
			</div>

		</div>
		<input name="mhcx" value="${mhcx }" type="hidden">
		<div class="row">
			<div class="col-sm-10" align="center">
				<input type="submit" value="添加用户" class="btn btn-success" /> <a
					href="user/findAll.do?mhcx=${mhcx }" class="btn btn-danger">返回上一级</a>
			</div>
		</div>
	</form>


</body>
</html>