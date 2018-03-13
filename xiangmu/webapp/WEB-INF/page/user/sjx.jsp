<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager"%>
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
<title>收件箱</title>
<link rel="stylesheet" href="res/css/bootstrap.css">
<script type="text/javascript" src="res/js/jquery.min.js"></script>
<script type="text/javascript" src="res/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function() {

		//给修改按钮绑定事件
		$("#delete").click(function() {
			var ids = $("input[id=ids]:checked");
			if (ids.length !=0) {
			if (confirm("您确定要删除用户吗")) {
				//提交表单
				var f1 = $("#f1");
				f1.attr("action", "user/deleteyj.do");
				f1.submit();
			}
		  }else{
			  alert("必须选自一个（只能有一个）进行修改");
		  }
		});


	});

	//checkboxfun 实现全选货全不选
	function checkboxfun(v) {
		//alert(v.checked);
		var ids = $("input[id=ids]");
		//遍历所有的checkbox
		ids.each(function(i) {
			//设置checked的值
			this.checked = v.checked;
		});
	}
</script>

</head>
<body>
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px; padding-left: 20px;">
			<li>收件箱</li>
			
		</ul>
	</div>
	<form action="user/sjx.do" method="post" id="f1" class="form-inline">
		<div class="row alert alert-info" style="margin: 0px; padding: 5px;">
			<div class="form-group">
				<label>发件人查询</label> <input type="text" class="form-control"
					name="fjrxm" placeholder="请输入发件人姓名"  />
					<input type="submit" value="查询姓名" class="btn btn-danger" />
			</div>
			
			<a href="user/fyj.do" value="发邮件" class="btn btn-danger" >发邮件</a>
			 <input type="button" id="delete" value="删除邮件" class="btn btn-danger" />
		</div>
	
		<div class="row" style="padding: 15px;">
			<table class="table ">
				<tr>
					<th><input type="checkbox" onclick="checkboxfun(this)" /></th>
					<th>发件人</th>
					<th>主题</th>
					<th>时间</th>
					<th>查看</th>
				<c:forEach var="s" items="${sjxlist}">
					<tr>
						<td><input type="checkbox" id="ids"  name="id" value="${s.id}" /></td>
	
						<td>${s.fjrxm}</td>
						<td>${s.zhuti }</td>
						<td>${s.shijian }</td>
						<c:if test="${s.state=='0' }">
							<td><span class="btn btn-danger">未回复</span></td>
						</c:if>
						<c:if test="${s.state=='1' }">
							<td><span class="btn btn-primary">已回复</span></td>
						</c:if>
						<td><a href="user/chakanyj.do?id=${s.id }">查看</a></td>
					</tr>
					
				</c:forEach>	
			
			</table>

		</div>
		
		
		
	</form>
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>

</html>