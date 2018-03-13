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
<title>首页</title>
<link rel="stylesheet" href="res/css/bootstrap.css">
<script type="text/javascript" src="res/js/jquery.min.js"></script>
<script type="text/javascript" src="res/js/bootstrap.min.js"></script>
</head>
<body>
	<a href="menu/tjtz.do" class="btn btn-info">添加下级菜单</a>
	<a href="menu/dancha.do?Menu_id=${Menu_id }&pd=1" class="btn btn-primary">修改菜单</a>
	<a href="menu/delete.do?Menu_id=${Menu_id }" class="btn btn-danger">删除菜单</a>
	<h5 class="page-header alert-info"
		style="margin: 0px; padding: 10px; margin-bottom: 10px">菜单详细信息</h5>
	<div class="row">
		<div class="col-sm-6">
			<div class="form-group">
				<label class="col-sm-3 control-label">菜单名称</label>
				<div class="col-sm-9">
					<p class="form-control-static">${Menu_Info.menu_name }</p>
				</div>
			</div>
		</div>
		<div class="col-sm-6">
			<div class="form-group">
				<label class="col-sm-3 control-label">上级菜单</label>
				<div class="col-sm-5">
					<p class="form-control-static">${shangji.menu_name }</p>
				</div>
			</div>
		</div>
		<div class="col-sm-12">
			<div class="form-group">
				<label class="col-sm-3 control-label">菜单地址</label>
				<div class="col-sm-5">
					<p class="form-control-static">${Menu_Info.menu_url }</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>