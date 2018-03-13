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
<title>角色添加</title>
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
			<li>角色管理</li>
			<li>添加角色</li>
		</ul>
	</div>
	<form action="role/insert.do" method="post" class="form-horizontal"  data-validator-option="{timely:2, theme:'yellow_right_effect'}">
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px">角色基本信息</h5>
		<div class="row">
			<div class="col-sm-7">
				<div class="form-group form-item">
					<label class="col-sm-3 control-label">角色名称</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" name="Role_name"
							placeholder="请输入角色名称" 
							data-rule="required;Role_name;"
							data-rule-Role_name="[/^[\u4e00-\u9fa5]{2,7}$/, '请重新输入']"
							data-tip="请输入汉字" 
							data-msg-required="请填写角色名称"/>
					</div>
				</div>
			</div>
<!-- 隐藏域 -->


			<input type="hidden" name="mhcx" value="${mhcx }">
			<div class="col-sm-7">
				<div class="form-group form-item">
					<label class="col-sm-3 control-label">角色描述</label>
					<div class="col-sm-9">
						<textarea rows="" cols="" class="form-control"
							placeholder="请输入角色描述信息" name="Role_desc"
							data-rule="required;Role_desc;"
							data-rule-Role_desc="[/^[\u4e00-\u9fa5]{3,30}$/, '输入有误,请重新输入']"
							data-tip="请描述角色" 
							data-msg-required="请输入角色描述"
							></textarea>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-7" align="center">
				<input type="submit" value="添加角色" class="btn btn-success"/>
				<a href="role/findAll.do?mhcx=${mhcx }" class="btn btn-danger">返回上一级</a>
			</div>
		</div>
	</form>


</body>
</html>