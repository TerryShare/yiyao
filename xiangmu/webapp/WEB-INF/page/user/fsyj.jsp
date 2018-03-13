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
<title>薪资发放</title>
<link rel="stylesheet" href="res/css/bootstrap.css">
<script type="text/javascript" src="res/js/jquery.min.js"></script>
<script type="text/javascript" src="res/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="res/gj/demo.css">
<script src="https://cdn.jsdelivr.net/jquery/1.12.3/jquery.min.js"></script>
<script src="res/gj/jquery.validator.min.js?local=en"></script>
<script type="text/javascript"
	src="<%=basePath%>res/My97DatePicker/WdatePicker.js"></script>
	
</head>
<body>
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px; padding-left: 20px;">
			<li>发邮件</li>

		</ul>
	</div>
	<form action="user/inyj.do" method="post" class="form-horizontal">
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px">邮件信息</h5>
		<div class="row">
			<div class="col-sm-7">
				<div class="form-group">
					<label class="col-sm-3 control-label">收件人</label>
					<div class="col-sm-9">
						<select name="shoujianrenid" class="form-control">
						<c:forEach var="s" items="${userlist }">
							<option value="${s.user_id }">${s.user_name }</option>
						</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<div class="col-sm-7">
				<div class="form-group form-item">
					<label class="col-sm-3 control-label">邮件主题</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" placeholder="请书写主体" name="zhuti"/>
					</div>
				</div>
			</div>
			<div class="col-sm-7">
				<div class="form-group form-item">
					<label class="col-sm-3 control-label">邮件内容</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" placeholder="请书写内容" name="neirong"/>
					</div>
				</div>
			</div>
	
		</div>
		<div class="row">
			<div class="col-sm-7" align="center">
				<input type="submit" value="确认发送" class="btn btn-success" /> 
			</div>
		</div>
	</form>

</body>
</html>