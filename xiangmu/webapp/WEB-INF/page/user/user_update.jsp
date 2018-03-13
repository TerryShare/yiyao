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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户修改</title>
<link rel="stylesheet" href="res/css/bootstrap.css">
<script type="text/javascript" src="res/js/jquery.min.js"></script>
<script type="text/javascript" src="res/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="res/gj/demo.css">
<script src="https://cdn.jsdelivr.net/jquery/1.12.3/jquery.min.js"></script>
<script src="res/gj/jquery.validator.min.js?local=en"></script>



</head>
<body>
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px; padding-left: 20px;">
			<li>系统管理</li>
			<li>用户管理</li>
			<li>修改用户</li>
		</ul>
	</div>
	<form action="user/update.do" method="post" class="form-horizontal"  data-validator-option="{timely:2, theme:'yellow_right_effect'}">
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px">用户基本信息</h5>
		<div class="row">
			<div class="col-sm-5 form-item">
				<div class="form-group">
					<label class="col-sm-3 control-label">用户姓名</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" name="User_name"
							placeholder="请输入用户姓名" value="${dcUser_Info.user_name }" id="xingming"
							data-rule="required;User_name;"
							data-rule-User_name="[/^[\u4E00-\u9FA5]{3,50}$/, '请重新输入']"
							data-tip="请输入字母或数字 3 - 12" 
							data-msg-required="请填写名字";
							/>
							
							<!-- 新增的 -->
							<label  style="color:red"></label>
					</div>
				</div>
			</div>
<!-- 隐藏域  -->
			<input type="hidden" name="pd" value="${pd }">
			<input type="hidden" name="mhcx" value="${mhcx }">
			<div class="col-sm-5">
				<div class="form-group form-item">
					<label class="col-sm-3 control-label">用户性别</label>
					<div class="col-sm-5">
						<select name="User_sex" class="form-control" value="${dcUser_Info.user_sex }">
							<option>保密</option>
							<option selected="selected">男</option>
							<option>女</option>
						</select>
					</div>
				</div>
			</div>
			<input type="hidden" name="user_id" value="${dcUser_Info.user_id }">
			<div class="col-sm-5" id="dd">
				<div class="form-group form-item">
					<label class="col-sm-3 control-label">用户年龄</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" name="User_age"
							placeholder="请输入用户年龄" value="${dcUser_Info.user_age }" id="nianling" 
							data-rule="required; User_age;"
							data-rule-User_age="[/^[\d]{1,2}$/, '请输入正确的年龄']"
							data-tip="请输入您的年龄" 
							data-msg-required="请填写年龄";
							/>
						
					</div>
				</div>
			</div>
			<div class="col-sm-5" id="div1">
				<div class="form-group form-item">
					<label class="col-sm-3 control-label">薪资</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" name="User_salary"
							placeholder="请输入薪资" value="${dcUser_Info.user_salary }" class="xinzi" 
							data-rule="required; User_salary;"
							data-rule-User_salary="[/^[\d]{1,6}[.]{0,1}[\d]{1,4}$/, '请输入正确的月薪']"
							data-tip="请输入月薪" />
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
					<div class="col-sm-9 form-item">
						<input type="text" class="form-control" name="User_account"
							placeholder="请输入用户账号" value="${dcUser_Info.user_account }" class="zhanghao" 
							data-rule="required; User_account"
							data-rule-User_account="[/^[\w\d]{3,12}$/, '请输入正确的账号']"
							data-tip="请输入您的新账号" 
							data-msg-required="请填写账号";
							/>
					</div>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">用户密码</label>
					<div class="col-sm-9 form-item">
						<input type="password" class="form-control" name="User_password"
							placeholder="请输入用户密码" value="${dcUser_Info.user_password }" id="mima" 
							data-rule="required; User_account;"
							data-rule-User_password="[/^[\w\d]{3,12}$/, '请用数字或字母']"
							data-tip="请输入您密码" 
							data-msg-required="请填写密码";
							/>
					</div>
				</div>
			</div>

			</div>
		<div class="row">
			<div class="col-sm-10" align="center">
				<input type="submit" value="修改用户" class="btn btn-success" /> <a
					href="user/findAll.do?mhcx=${mhcx}" class="btn btn-danger">返回上一级</a>
			</div>
		</div>
	</form>
	
	<!-- <form class="form"
		data-validator-option="{timely:2, theme:'yellow_right_effect'}">

		<div class="form-item">
			<label class="label">Username</label> <input type="text"
				name="username" data-rule="required;username;"
				data-rule-username="[/^[\w\d]{3,12}$/, 'Please enter 3-12 digits, letters, underscores']"
				data-tip="You can use letters, numbers and periods">
		</div>

		<div class="form-item">
			<button type="submit">Submit</button>
		</div> -->
</form>
</body>
</html>