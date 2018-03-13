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


 <body>
     <div align="center" style=" position:fixed; left:0; top:0px; width:100%; height:100%;">
           <canvas id="q" width="1440" height="900"></canvas>
     </div>
 </body>

<script typet="text/javascript" src="http://libs.baidu.com/jquery/1.8.3/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery/1.12.3/jquery.min.js"></script>
<script src="res/dist/jquery.validator.min.js?local=en"></script>

<base href="<%=basePath%>">
<title>用户登录</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="res/assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="res/assets/css/font-awesome.min.css" />
<link rel="stylesheet" href="res/assets/css/ace.min.css" />
<link rel="stylesheet" href="res/assets/css/ace-rtl.min.css" />
</head>
<body class="login-layout">
	<div class="main-container">
		<div class="main-content">
			<div class="row">
				<div class="col-sm-10 col-sm-offset-1">
					<div class="login-container">
						<div class="center">
							<h1>
								<i class="icon-leaf green"></i> <span class="red">智达教育</span> <span
									class="white">费用管理系统</span>
							</h1>
							<h4 class="blue"></h4>
						</div>
						<div class="space-6"></div>
						<div class="position-relative">
							<div id="login-box"
								class="login-box visible widget-box no-border">
								<div class="widget-body">
									<div class="widget-main">
										<h4 class="header blue lighter bigger">
											<i class="icon-coffee green"></i> 请输入您的账号和密码
										</h4>

										<div class="space-6"></div>
										<form action="user/login.do" method="post" onsubmit="return check()">
											<fieldset>
												<label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input id="userId"
														name="User_account" type="text" class="form-control"
														placeholder="请输入账号" />
													 <i class="icon-user"></i>
												</span>
												</label> 
												<label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input id="userPw"
														name="User_password" type="password" class="form-control"
														placeholder="请输入密码" /> 
													<i class="icon-lock"></i>
												</span>
												</label>
												<div>
													<div id="v_container" style="width: 200px;height: 50px;"></div>
													验证码：<input type="text" id="code_input" value="" placeholder="请输入验证码"/>
 												</div>
												<div class="clearfix">
													<button type="submit" id="loginbt" onclick="validate()"
														class="width-35 pull-right btn btn-sm btn-primary">
														<i class="icon-key"></i> 登陆
													</button>
												</div>

												<div class="space-4"></div>
											</fieldset>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script src="res/js/gVerify.js"></script>
<script>
	var verifyCode = new GVerify("v_container");

	document.getElementById("loginbt").onclick = function(){
		var res = verifyCode.validate(document.getElementById("code_input").value);
		if(res){
			alert("验证正确");
		}else{
			alert("验证码错误");
			return false;
		}
	}
	  <%
      if(request.getAttribute("dlsb")!=null){
    	  String str=(String)request.getAttribute("dlsb");
    	  if(str.equals("1")){
 				request.removeAttribute("dlsb");
 				request.setAttribute("dlsb", "0");
 				%>
 				alert("账号或密码错误");
 				<%
 			}
      }
   		
      %>
</script>
</html>