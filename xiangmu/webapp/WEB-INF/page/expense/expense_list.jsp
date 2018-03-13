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
<title>我的报销单</title>
<link rel="stylesheet" href="res/css/bootstrap.css">
<script type="text/javascript" src="res/js/jquery.min.js"></script>
<script type="text/javascript" src="res/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath%>res/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px; padding-left: 20px;">
			<li>报销管理</li>
			<li>报销查询</li>
		</ul>
	</div>
	<!-- ?Expense_id=0 -->
	<form action="expense/findAll.do" method="post" id="f1"
		class="form-inline">
		<div class="row alert alert-info" style="margin: 0px; padding: 5px;">
			<div class="form-group">
				<label>报销人</label> <input type="text" class="form-control"
					name="User_name" placeholder="请输入报销人" value="${User_name }"/> <label>报销时间</label> <input
					type="text" class="form-control" name="Expense_time"
					placeholder="请输入报销时间" onclick="WdatePicker()" value="${Expense_time }"/>
			</div>
			<input type="submit" value="查询报销单" class="btn btn-success" />
		</div>
		
		<div class="row" style="padding: 15px;">
			<table class="table ">
				<tr>

					<th>报销编号</th>
					<th>报销原因</th>
					<th>报销人</th>
					<th>报销时间</th>
					<th>报销总金额</th>
					<th>审核状态</th>
					<th>查看明细</th>
				</tr>


				<c:forEach var="s" items="${Expenselist}">
					<tr>
						<td>${s.expense_id }</td>
						<td>${s.expense_desc }</td>
						<td>${s.user_name }</td>
						<td>${s.expense_time }</td>
						<td>${s.expense_total }</td>

						<c:if test="${s.expense_state=='-1' }">
							<td><span class="btn btn-danger">审核不通过</span></td>
						</c:if>
						<c:if test="${s.expense_state=='0' }">
							<td><span class="btn btn-success">正在审核</span></td>
						</c:if>
						<c:if test="${s.expense_state=='1' }">
							<td><span class="btn btn-info">经理审核通过</span></td>
						</c:if>
						<c:if test="${s.expense_state=='2' }">
							<td><span class="btn btn-primary">财务审核通过</span></td>
						</c:if>
						<c:if test="${s.expense_state=='del' }">
							<td><span class="btn btn-danger">审核作废</span></td>
						</c:if>
						<th><a href="expense/ckmx.do?expense_id=${s.expense_id }&User_name=${User_name}&Expense_time=${Expense_time}">查看明细</a></th>
					</tr>
				</c:forEach>
			</table>

		</div>
		<div align="right" style="padding: 10px;">
			<pg:pager items="${total }" url="expense/findAll.do" maxIndexPages="3"
				maxPageItems="5" export="currentPageNumber=pageNumber"
				scope="request">
				<pg:param name="User_name" value="${User_name }" />

				<jsp:include page="../../../res/jsp/pager_tag.jsp" flush="true" />
			</pg:pager>
		</div>
	</form>
</body>
</html>