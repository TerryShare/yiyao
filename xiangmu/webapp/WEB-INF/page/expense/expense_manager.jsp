<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>报销单经理审核</title>
<link rel="stylesheet" href="res/css/bootstrap.css">
<script type="text/javascript" src="res/js/jquery.min.js"></script>
<script type="text/javascript" src="res/js/bootstrap.min.js"></script>

<script src="https://cdn.jsdelivr.net/jquery/1.12.3/jquery.min.js"></script>
<script src="res/gj/jquery.validator.min.js?local=en"></script>
</head>
<body>
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px; padding-left: 20px;">
			<li>报销管理</li>
			<li>经理审核</li>

		</ul>
	</div>
<form action="expense/jlshenhe.do" method="post"
		class="form-horizontal" data-validator-option="{timely:2, theme:'yellow_right_effect'}" >
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px">报销单基本信息</h5>

		<c:forEach var="c" items="${jblist }">
			<div class="row">
				<div class="col-sm-7">
					<div class="form-group">
						<label class="col-sm-3 control-label">报销原因</label>
						<div class="col-sm-9">
							<p class="form-control-static">${c.expense_name }</p>
						</div>
					</div>
				</div>
				<div class="col-sm-7">
					<div class="form-group">
						<label class="col-sm-3 control-label">报销时间</label>
						<div class="col-sm-9">
							<p class="form-control-static">${c.expense_time }</p>
						</div>
					</div>
				</div>
				<div class="col-sm-7">
					<div class="form-group">
						<label class="col-sm-3 control-label">报销总金额</label>
						<div class="col-sm-9">
							<p class="form-control-static">${c.expense_total }</p>
						</div>
					</div>
				</div>
<input type="hidden" name="User_id" value="${c.user_id} ">
<input type="hidden" name="Expense_id" value="${c.expense_id} ">

				<div class="col-sm-7">
					<div class="form-group">
						<label class="col-sm-3 control-label">报销详情</label>
						<div class="col-sm-9">
							<p class="form-control-static">${c.expense_desc }</p>
						</div>
					</div>
				</div>
			</div>
</c:forEach>
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
			</tr>
		</table>

		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px">报销单审核信息</h5>
		<div class="row">
			<div class="col-sm-7">
				<div class="form-group">
					<label class="col-sm-3 control-label">审核状态</label>
					<div class="col-sm-9">
						<label class="radio-inline"> <input type="radio"
							name="Audit_state" value="1" data-rule="checked" />审核通过
						</label> <label class="radio-inline"> <input type="radio"
							name="Audit_state" value="-1" />审核不通过
						</label> <label class="radio-inline"> <input type="radio"
							name="Audit_state" value="del" />作废
						</label>
					</div>
				</div>
			</div>

			<div class="col-sm-7">
				<div class="form-group">
					<label class="col-sm-3 control-label">审核描述</label>
					<div class="col-sm-9">
						<textarea rows="" cols="" class="form-control"
							placeholder="请输入审核描述" name="Audit_desc"
							data-rule="required;Audit_desc;"
							data-rule-Audit_desc="[/^[\u4e00-\u9fa5a-zA-Z\d]{3,50}$/, '输入有误']"
							data-tip="请输入原因"
							></textarea>
							<input type="hidden" name="User_name" value="${User_name }"> <input
									type="hidden" name="Expense_time" value="${Expense_time }">
					</div>
				</div>
			</div>
		</div>
		

		<div class="row">
			<div class="col-sm-7" align="center">
				<input type="submit" value="审核提交" class="btn btn-success" />

			</div>
		</div>
	</form>
</body>
</html>