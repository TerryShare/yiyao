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
<title>权限变更</title>
<link rel="stylesheet" href="res/css/bootstrap.css">
<script type="text/javascript" src="res/js/jquery.min.js"></script>
<script type="text/javascript" src="res/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function(){
		$(".inp").on("click",function(){
				
			 if(!$(this).parent().parent().children().children(".fjd").is(":checked")){ 
				var s=$(this).parent().parent().children().children(".fjd").attr("checked",true);
			} 
		})
		
	})
</script>

</head>
<body>
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px; padding-left: 20px;">
			<li>系统管理</li>
			<li>权限管理</li>
			<li>权限变更</li>
		</ul>
	</div>
	<form action="anthority/update.do" method="post" id="f1" class="form-inline">
	<input type="hidden" name="id" value="${id }">
		<div class="row alert alert-info" style="margin: 0px; padding: 10px;">
			<h4 align="center">超级管理员</h4>
		</div>

		<div class="row" style="padding: 15px;">
			<table class="table ">
				<tr>

					<th>第一级菜单</th>
					<th>第二级菜单</th>

				</tr>
		<!-- 隐藏域 -->
					
				<c:forEach var="s" items="${alllist }">
					<c:if test="${s.prent_menu_id==0 }">
						<tr>		
							<td><input type="checkbox" name="Menu_id" value="${s.menu_id }" class="fjd"
								<c:forEach var="c" items="${dclist }">
									<c:if test="${s.menu_id==c.menu_id }">
										checked
									</c:if>
								</c:forEach>
							/>${s.menu_name }</td>
					
						
						
						<c:forEach var="a" items="${alllist1 }"> 
									<c:if test="${a.prent_menu_id==s.menu_id }">
						<td><input type="checkbox" name="Menu_id"  class="inp" value="${a.menu_id }"
							<c:forEach var="c1" items="${dclist }">
									<c:if test="${a.menu_id==c1.menu_id }">
										checked
									</c:if>
								</c:forEach>
							/>${a.menu_name }
						</td>
									</c:if>
								</c:forEach>
					</c:if>
				</c:forEach>
					</tr>
				
			</table>

		</div>
		<center>
		<input type="hidden" name="mhcx" value="${mhcx }">
		<input type="submit" value="提交" class="btn btn-success" /> 
		</center>
	</form>
</body>
</html>