<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加Excel表格</title>
<script src="res/nice-validator-1.1.1/dist/jquery.validator.js?local=zh-CN"></script>
<script src="https://cdn.jsdelivr.net/jquery/1.12.3/jquery.min.js"></script>
<script src="res/dist/jquery.validator.js?local=zh-CN"></script>
<script typet="text/javascript" src="http://libs.baidu.com/jquery/1.8.3/jquery.min.js"></script>

</head>

<body>
	<div align="center" style="margin-top: 100px" id="g1">
		<form action="addExcel.do" method="post" enctype="multipart/form-data">
			<input type="file" class="file" name="file" value=""/>
			<input type="submit" value="确定"/>
		</form>
	</div>
</body>
</html>