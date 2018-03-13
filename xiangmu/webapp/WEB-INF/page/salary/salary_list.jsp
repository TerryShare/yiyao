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
<title>薪资发放查询</title>
<link rel="stylesheet" href="res/css/bootstrap.css">
<script type="text/javascript" src="res/js/jquery.min.js"></script>
<script type="text/javascript" src="res/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath%>res/My97DatePicker/WdatePicker.js"></script>
<script>
function openWin(){
	myWindow=window.open('salary/Excel.do','','width=500,height=300');
	
}
</script>

</head>
<body>
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px; padding-left: 20px;">
			<li>薪资管理</li>
			<li>薪资发放查询</li>

		</ul>
	</div>
	<form action="salary/findAll.do" method="post" id="f1" class="form-inline">
		<div class="row alert alert-info" style="margin: 0px; padding: 5px;">
			<div class="form-group">
				<label>领取人</label> <input type="text" class="form-control" name="mhcx"
					placeholder="请输入领取人" value="${mhcx }" /> <label>发放时间</label> <input type="text"
					class="form-control" name="Payment_time" placeholder="请输入发放时间" value="${Payment_time }"  onclick="WdatePicker()"/>
			</div>
			<input type="submit" value="查询" class="btn btn-success" />
			<a class="btn btn-success" value="" onclick="openWin()">导入Excel</a>
		</div>
	<c:if test="${total!=0 }">
		<div class="row" style="padding: 15px;">
			<table class="table ">
			<c:forEach var="s" items="${Salarylist }">
				<tr>
					<td>${s.payment_id }</td>
					<td>${s.user_name }</td>
					<td>${s.payment_time }</td>
					<td>${s.payment_money }</td>
				</tr>
			</c:forEach>
			
			</table>

		</div>
		
		
		<div align="right" style="padding: 10px;">
			<pg:pager items="${total }" url="salary/findAll.do" maxIndexPages="3"
				maxPageItems="5" export="currentPageNumber=pageNumber"
				scope="request">
				<pg:param name="mhcx" value="${mhcx }" />

				<jsp:include page="../../../res/jsp/pager_tag.jsp" flush="true" />
			</pg:pager>
		</div>
		</c:if>
	</form>
</body>
</html>