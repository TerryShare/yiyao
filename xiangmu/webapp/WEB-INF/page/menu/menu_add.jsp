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
<title>首页</title>
<link rel="stylesheet" href="res/css/bootstrap.css">
<script type="text/javascript" src="res/js/jquery.min.js"></script>
<script type="text/javascript" src="res/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="res/gj/demo.css">
<script src="https://cdn.jsdelivr.net/jquery/1.12.3/jquery.min.js"></script>
<script src="res/gj/jquery.validator.min.js?local=en"></script>
</head>
<body>
	<form action="menu/insert.do" method="post" class="form-horizontal">
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px">菜单基本信息</h5>
		<div class="row">
			<div class="col-sm-6">
				<div class="form-group">
					<label class="col-sm-3 control-label">菜单名称</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" name="Menu_name"
							placeholder="请输入菜单名称" 
							data-rule="required;Menu_name;"
							data-rule-Menu_name="[/^[\u4E00-\u9FA5]{2,6}$/, '请重新输入']"
							data-tip="请输入字母或汉字 3 - 12"
							/>
					</div>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="form-group">
					<label class="col-sm-3 control-label">父级菜单</label>
					<div class="col-sm-5">
						<select name="Prent_menu_id" class="form-control">
								<c:forEach var="s" items="${list}">
								<option value="${s.menu_id }">${s.menu_name }</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<div class="col-sm-12">
				<div class="form-group">
					<label class="col-sm-3 control-label">菜单地址</label>
					<div class="col-sm-7">
						<input type="text" class="form-control" name="Menu_url"
							placeholder="请输入菜单地址"
							data-rule="required;Menu_url;"
							data-rule-Menu_url="[/^[a-z,A-Z]{2,6}\/[a-z,A-Z]{2,6}.do$/, '请填写地址***/***.do']"
							data-tip="请输入字母或数字 3 - 12"
							data-msg-required="请填写地址***/***.do"
							 />
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-10" align="center">
				<input type="submit" value="添加菜单" class="btn btn-success" />
			</div>
		</div>
	</form>
</body>
</html>