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
<title>角色查询</title>
<link rel="stylesheet" href="res/css/bootstrap.css">
<script type="text/javascript" src="res/js/jquery.min.js"></script>
<script type="text/javascript" src="res/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function() {

		//给修改按钮绑定事件
		$("#update").click(function() {
			var roleids = $("input[id=roleids]:checked");
			if(roleids.length ==1){
				//提交表单
				var f1 = $("#f1");
				f1.attr("action","role/loadupdate.do");
				f1.submit();
				
			}else{
				alert("必须选自一个（只能有一个）进行修改");
			}
		});
		
		//给删除按钮绑定事件
		$("#delete").click(function(){
			if(confirm("您确定要删除角色吗")){
				//提交表单
				var f1 = $("#f1");
				f1.attr("action","role/delete.do");
				f1.submit();
			}
			
		});

	});
	
	//checkboxfun 实现全选货全不选
	function checkboxfun(v){
		//alert(v.checked);
		var roleids = $("input[id=roleids]");
		//遍历所有的checkbox
		roleids.each(function(i){
			//设置checked的值
			this.checked=v.checked;
			
			//	$(this).attr("checked",v.checked);
		});
	}
</script>

</head>
<body>
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px; padding-left: 20px;">
			<li>系统管理</li>
			<li>角色管理</li>
			<li>查询角色</li>
		</ul>
	</div>
	<form action="" method="post" id="f1" class="form-inline">
		<div class="row alert alert-info" style="margin: 0px; padding: 5px;">
			<div class="form-group">
				<label>角色名称</label> <input type="text" class="form-control"
					name="roleName" placeholder="请输入角色名称" />
			</div>
			<input type="submit" value="查询角色" class="btn btn-success" /> <a
				href="role/loadadd.do" class="btn btn-info">添加角色</a> <input
				type="button" id="update" value="修改角色" class="btn btn-primary" /> <input
				type="button" id="delete" value="删除角色" class="btn btn-danger" />
		</div>

		<div class="row" style="padding: 15px;">
			<table class="table ">
				<tr>
					<th><input type="checkbox" onclick="checkboxfun(this)" /></th>
					<th>角色编号</th>
					<th>角色名称</th>
					<th>角色描述</th>

				</tr>
				<tr>
					<td><input type="checkbox" checked="checked" id="roleids" /></td>
					<td>1001</td>
					<td>普通管理员</td>
					<td>可以添加用户，删除用户、修改用户</td>
				</tr>
				<tr>
					<td><input type="checkbox" id="roleids" /></td>
					<td>1001</td>
					<td>普通管理员</td>
					<td>可以添加用户，删除用户、修改用户</td>
				</tr>
				<tr>
					<td><input type="checkbox" id="roleids" /></td>
					<td>1001</td>
					<td>普通管理员</td>
					<td>可以添加用户，删除用户、修改用户</td>
				</tr>
				<tr>
					<td><input type="checkbox" id="roleids" /></td>
					<td>1001</td>
					<td>普通管理员</td>
					<td>可以添加用户，删除用户、修改用户</td>
				</tr>
				<tr>
					<td><input type="checkbox" id="roleids" /></td>
					<td>1001</td>
					<td>普通管理员</td>
					<td>可以添加用户，删除用户、修改用户</td>
				</tr>

			</table>

		</div>
	</form>
</body>
</html>