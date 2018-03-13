<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>报销单</title>
<link rel="stylesheet" href="res/css/bootstrap.css">
<script type="text/javascript" src="res/js/jquery.min.js"></script>
<script type="text/javascript" src="res/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath%>res/My97DatePicker/WdatePicker.js"></script>
<script src="https://cdn.jsdelivr.net/jquery/1.12.3/jquery.min.js"></script>
<script src="res/gj/jquery.validator.min.js?local=en"></script>


<script src="http://libs.baidu.com/jquery/1.8.3/jquery.min.js" type="text/javascript"></script>


<script type="text/javascript"
	src="<%=basePath%>res/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">

	$(function() {
	 	
	 $(".inp").live("focusout",function(){  
			 var str1=$(this).val();
			var $ts='<span style="color:red" class="sp">请输入正确的金额</span>'; 
			 var zz=/^\d{1,4}\.[\d]{1,4}$/;
             if(!zz.test(str1)){
            	 $(this).parent().next().html($ts);
            }else{
      
            	$(this).parent().next().html("");
            }
			
		});
		$("#selected")
				.click(
						function() {

							//获取table
							var tab1 = $("#tab1");

							var ids = $("input[id=ids]:checked");

							ids
									.each(function() {
										var costId = $(this).val();

										var td = $(this).parent().parent()
												.find("td");

										tab1
												.append("<tr><td>"
														+ td[2].innerHTML
														+ "</td><td>"
														+ td[3].innerHTML
														+ "<input type='hidden' name='costId' value='"+costId+"'>"
														+ "</td><td><input type='text' id='memony' onblur='total()' name='detailsAmount' class='inp' " 
														+"></td><td style='width:30%'></td></tr>");

									});
							//隐藏模态框
							$("#myModal").modal('hide');
							
						});

	});

	//计算报销总金额
	function total() {
		var sum = 0;

		$("input[id=memony]").each(function() {
		
			var zz=/^\d{1,4}[\/.]{0,1}\d{1,3}$/
			if(!zz.test($(this).val())){
				sum="错误计算";
			
			}else{
			sum = sum + parseFloat($(this).val());
			}
		});
		
		
		$("input[name=expenseTotal]").val(sum);
	}
</script>
</head>
<body>
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px; padding-left: 20px;">
			<li>报销管理</li>
			<li>报销单</li>

		</ul>
	</div>

	<div class="alert alert-warning alert-dismissible"
		style="display: ${errorinfo==null?'none':'block' };" role="alert">
		<button type="button" class="close" data-dismiss="alert"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
		<div align="center" style="color: red;">${errorinfo }</div>
	</div>
	<form action="expense/add.do" method="post" class="form-horizontal" id="f1">
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px" >报销单基本信息</h5>
		<div class="row">
			<div class="col-sm-7">
				<div class="form-group">
					<label class="col-sm-3 control-label">报销原因</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" name="Expense_name"  
							placeholder="请输入报销原因" 
							data-rule="required;Expense_name;"
							data-rule-Expense_name="[/^[\u4e00-\u9fa5]{3,50}$/, '输入有误']"
							data-tip="请输入原因"
							 data-msg-required="请填写原因"
							/>
					</div>
				</div>
			</div>
			<div class="col-sm-7">
				<div class="form-group">
					<label class="col-sm-3 control-label">报销时间</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" name="Expense_time"
							placeholder="请输入报销报销时间" onclick="WdatePicker()" onclick="WdatePicker()" 
									data-rule="required;Expense_time;"
									data-tip="请选择时间"
									 data-msg-required="请选择时间"
							/>
					</div>
				</div>
			</div>
			<div class="col-sm-7">
				<div class="form-group">
					<label class="col-sm-3 control-label">报销总金额</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" name="expenseTotal" onkeyup="this.value=this.value.replace(/[^0-9]/g,'')" maxlength="9"
							placeholder="请输入报销总金额" readOnly="readonly" 
							data-rule-expenseTotal="[/^[\d]{1,6}.{0,1}[\d]{0,4}$/, '请重新输入金额']"
							data-rule="required;expenseTotal;"
							data-tip="系统自动计算"
							 data-msg-required="请选择资金"
							/>
					</div>
				</div>
			</div>
			<div class="col-sm-7">
				<div class="form-group">
					<label class="col-sm-3 control-label">报销详情</label>
					<div class="col-sm-9">
						<textarea rows="" cols="" class="form-control"
							placeholder="请输入报销详情" name="Expense_desc"
							data-rule="required;Expense_desc";
							data-rule-Expense_desc="[/^[\u4e00-\u9fa5]{3,50}$/, '报销详情输入有误,请重新输入']"
							data-tip="请输入报销详情"
							 data-msg-required="请填写报销详情"
							></textarea>
					</div>
				</div>
			</div>
		</div>
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px">
			报销单明细 <input type="button" class="btn btn-primary btn-xs"
				value="选择费用明细" data-toggle="modal" data-target="#myModal" 
				/>
		</h5>
		<table class="table" id="tab1">
			<tr>
				<th>费用名称</th>
				<th>费用说明</th>
				<th>具体金额</th>
			</tr>

		</table>

		<div class="row">
			<div class="col-sm-7" align="center">
				<input type="submit" value="提交报销单" class="btn btn-success" id="bu"/>

			</div>
		</div>
	</form>
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">费用明细</h4>
				</div>
				<div class="modal-body">
					<table class="table " id="tab2">
						<tr>
							<th></th>
							<th>费用编号</th>
							<th>费用名称</th>
							<th>费用描述</th>

						</tr>

						<c:forEach var="cost" items="${costlist }">
							<tr>
								<td><input type="checkbox" id="ids" name="costId"
									value="${cost.cost_id }" /></td>
								<td>${cost.cost_id }</td>
								<td>${cost.cost_name }</td>
								<td>${cost.cost_desc }</td>
							</tr>

						</c:forEach>

					</table>
				</div>
				<div class="modal-footer">
					<button type="button" id="selected" class="btn btn-primary" data-dismiss="modal">选择</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>

				</div>
			</div>
		</div>
	</div>




</body>
</html>