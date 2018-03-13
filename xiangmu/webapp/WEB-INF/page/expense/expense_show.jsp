<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<title>报销单</title>
<link rel="stylesheet" href="res/css/bootstrap.css">
<script type="text/javascript" src="res/js/jquery.min.js"></script>
<script type="text/javascript" src="res/js/bootstrap.min.js"></script>

</head>
<body>
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px; padding-left: 20px;">
			<li>报销管理</li>
			<li>报销单明细</li>

		</ul>
	</div>
	<form action="" method="post" class="form-horizontal">
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px">报销单基本信息</h5>
		<div class="row">
			<div class="col-sm-7">
				<div class="form-group">
					<label class="col-sm-3 control-label">报销原因</label>
					<div class="col-sm-9">
						<p class="form-control-static">${jblist.get(0).expense_name }</p>
					</div>
				</div>
			</div>
			<div class="col-sm-7">
				<div class="form-group">
					<label class="col-sm-3 control-label">报销时间</label>
					<div class="col-sm-9">
						<p class="form-control-static">${jblist.get(0).expense_time }</p>
					</div>
				</div>
			</div>
			<div class="col-sm-7">
				<div class="form-group">
					<label class="col-sm-3 control-label">报销总金额</label>
					<div class="col-sm-9">
						<p class="form-control-static">${jblist.get(0).expense_total }</p>
					</div>
				</div>
			</div>
			<div class="col-sm-7">
				<div class="form-group">
					<label class="col-sm-3 control-label">报销详情</label>
					<div class="col-sm-9">
						<p class="form-control-static">${jblist.get(0).expense_desc }</p>
					</div>
				</div>
			</div>
		</div>
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px">报销单明细</h5>
		<table class="table" id="tab1">
			<tr>
				<th>费用名称</th>
				<th>费用说明</th>
				<th>具体金额</th>
			</tr>
			<c:forEach var="s" items="${bxlist }">
				<tr>
					<td>${s.cost_name}</td>
					<td>${s.cost_desc}</td>
					<td>${s.expense_details_amount}</td>
				</tr>
			</c:forEach>
		</table>

		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px">审核历史记录信息</h5>
		<table class="table">
			<tr>
				<th>审核编号</th>
				<th>审核人</th>
				<th>审核状态</th>
				<th>审核时间</th>
				<th>审核描述</th>
			</tr>
			<c:forEach var="a" items="${lslist }">
				<tr>
					<td>${a.expense_id }</td>
					<td>${a.user_name }</td>
					<c:if test="${a.audit_state=='-1' }">
							<td>不通过</td>
						</c:if>
						<c:if test="${a.audit_state=='0' }">
							<td>正在审核</td>
						</c:if>
						<c:if test="${a.audit_state=='1' }">
							<td>经理审核通过</td>
						</c:if>
						<c:if test="${a.audit_state=='2' }">
							<td>财务审核通过</td>
						</c:if>
						<c:if test="${a.audit_state=='del' }">
							<td>审核作废</td>
						</c:if>
					<td>${a.audit_time }</td>
					<td>${a.audit_desc }</td>
				</tr>
				
			</c:forEach>
		</table>
		<div class="row">
			<div class="col-sm-7" align="center">
				<a href="expense/findAll.do?&User_name=${User_name}&Expense_time=${Expense_time}" class="btn btn-info">返回上一级</a>

			</div>
		</div>
	</form>
</body>
</html>