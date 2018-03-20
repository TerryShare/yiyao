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


<base href="<%=basePath%>">
<title>用户登录</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/font-awesome.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace-rtl.min.css" />
<link  rel="stylesheet" href="${pageContext.request.contextPath}/assets/uploadify/uploadify.css"></link>
</head>
<body class="login-layout">
	<div class="main-container">
		<div class="main-content">
			<div class="row">
				<div class="col-sm-10 col-sm-offset-1">
					<div class="login-container">
						<div class="center">
							<h1>
								<i class="icon-leaf green"></i> <span class="red"><!-- 智达教育 --></span> <span
									class="white">社区快速送药系统</span>
							</h1>
							<h4 class="blue"></h4>
						</div>
						<div class="space-6"></div>
						<div class="position-relative">
							<div id="login-box"
								class="login-box visible widget-box no-border">
								<div class="widget-body">
									<div class="widget-main" id="denglu">
										<h4 class="header blue lighter bigger">
											<i class="icon-coffee green"></i> 请输入您的账号和密码
										</h4>

										<div class="space-6"></div>
<!-- 										<form action="user/login.do" method="post" onsubmit="return check()">
 -->											<fieldset>
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
												<div class="clearfix">
													<button type="button" id="zhuce">
														<i class="icon-key"></i> 注册
													</button>
												</div>
												<div class="clearfix">
													<button type="submit" id="loginbt" 
														class="width-35 pull-right btn btn-sm btn-primary">
														<i class="icon-key"></i> 登陆
													</button>
												</div>

												<div class="space-4"></div>
											</fieldset>
									<!-- 	</form> -->
									</div>
									<!--注册页面  -->
									<from id="zcshangchu" >
								<div class="widget-main" style="display:none" id="zhuceyem">
										<h4 class="header blue lighter bigger">
											<i class="icon-coffee green"></i> 注册
										</h4>

										<div class="space-6"></div>
<!-- 										
 -->											<fieldset>
												<label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input id="userIdzhuce"
														name="User_account" type="text" class="form-control"
														placeholder="请输入注册账号" />
													 <i class="icon-user"></i>
												</span>
												</label> 
												<label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input id="userPwzhuce"
														name="User_password" type="password" class="form-control"
														placeholder="请输入注册密码" /> 
													<i class="icon-lock"></i>
												</span>
												</label>
												<input class="radio2" type="radio" name="radio2" value="3" id="jumin" checked/>居民
												<input class="radio2" type="radio" name="radio2" value="2"/>医生
												<input class="radio2" type="radio" name="radio2" value="1"/>商家
												<div id="udateiy" style="display:none">
												 <span id="uploadfiles"></span>
												<div class="adjunct" style="margin-top:-15px;margiin-left:80px;"></div>
												</div>
												 <span id="uploadfiles"></span>
												
												<div class="clearfix">
													<button type="submit" id="loginbtzhuce" 
														class="width-35 pull-right btn btn-sm btn-primary">
														<i class="icon-key"></i> 注册
													</button>
												</div>

												<div class="space-4"></div>
											</fieldset>
									</div>
									</from>
								<div>
									
								
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script  type="text/javascript" src="http://libs.baidu.com/jquery/1.9.1/jquery.min.js"></script>
<script  type="text/javascript" src="${pageContext.request.contextPath}/assets/uploadify/jquery.uploadify.js"></script>
<script>
	$(function(){
		$("#loginbt").click(function(){
			var name=$("#userId").val();
			var password=$("#userPw").val();
			if(name==""||password==""){
				alert("请输入账号或密码");
				return;
			}else{
				var requestDate={"name":name,"password":password};
				var str=JSON.stringify(requestDate);
				 $.ajax({
				       type: "get",
				       dataType: 'json',//默认转化对象
				       async:true,
				       url:  "user/login.do", //提交到一般处理程序请求数据
				       
				       data:{"requestDate":str},
				       error: function(){
				    	   alert("请求失败,轻语管理员联系")
				       },
				       success: function(data) {
				    	   var suc=data.succ;
				    	   
				    	   if(suc=="false"){
				    		   alert("账号或密码错误");
				    	   }else{
				    		   window.location.href=suc;
				    	   }
				       }
				   })
			}
		})
		
		//点击注册 跳转页面
		$("#zhuce").click(function(){
			$("#zhuceyem").show();
			 $("#denglu").hide(); 
		})
		//单选框变化
		$(".radio2").change(function(){
			$("#udateiy").hide();
			$("#filezc").hide();
			//判断身份
			var s=$(".radio2:checked").val();
			//如果是医生
			
			if(s=="2"){
				$("#udateiy").show();
				$("#filezc").show();
			}
		})
		//点击 提交的时候
		$("#loginbtzhuce").click(function(){
			//首先判断  身份 
			var s1=$(".radio2:checked").val();
			var name=$("#userIdzhuce").val();
			name=trim(name);
			var password=$("#userPwzhuce").val();
			password=trim(password);
			if(name==""){
				alert("请填写账号")
				return 
			}
			if(password==""){
				alert("请填写密码")
				return
			}
			//最大上传三个 不足 填空 
			var url=[];
			var requestDate={};
			if(s1=="2"){
				//首先 判断是否上传 附件 
				var a=$(".spans").length;
				if(a==0){
					alert("请上传医师资格证");
					return;
				}else{
					$(".spans").each(function(){
						var s=$(this).attr("fileurl");
						url.push(s);
					})
					if(url.length==1){
						requestDate={"name":name,"password":password,"code":s1,"t1":url[0],"t2":"","t3":""};
						
					}
					if(url.length==2){
						requestDate={"name":name,"password":password,"code":s1,"t1":url[0],"t2":url[1],"t3":""};
						
					}
					if(url.length==3){
						requestDate={"name":name,"password":password,"code":s1,"t1":url[0],"t2":url[1],"t3":url[2]};
					}

					
				}
			}else{
				requestDate={"name":name,"password":password,"code":s1};
			}
				
				var str=JSON.stringify(requestDate);
				 $.ajax({
				       type: "get",
				       dataType: 'json',//默认转化对象
				       async:true,
				       url:  "user/zhuce.do", //提交到一般处理程序请求数据
				       
				       data:{"requestDate":str},
				       error: function(){
				    	   alert("请求失败,请于管理员联系")
				       },
				       success: function(data) {
				    	   var suc=data.succ;
				    	   if(suc=="true"){
				    		   if(s1==2){
				    			   alert("注册成功,等待管理员审核!")
				    			   window.location.href="login.jsp";
				    		   }else{
				    			   alert("注册成功,请登录!");
				    			   window.location.href="login.jsp";
				    		   }
				    	   }else{
				    		   alert(suc);
				    	   }
				       }
				   })
			
			
			
		})
		
	
		//检查加载页是否安装flash插件
		function flashChecker() {  
	        try { 
	            if(typeof window.ActiveXObject != 'undefined') {
	               return parseInt((new ActiveXObject('ShockwaveFlash.ShockwaveFlash')).GetVariable("$version").split(" ")[1].split(",")[0], 10); 
	             }else{
	              return parseInt(navigator.plugins["Shockwave Flash"].description.split(' ')[2], 10);
	             }
	          } catch(e){
	            return 0;
	          };  
	    }
		function trim(str) {
			  return str.replace(/(^\s+)|(\s+$)/g, "");
			}
		  //上传文件
	    $("#uploadfiles").uploadify({
		   'swf':  'assets/uploadify/uploadify.swf',
	        'uploader': 'uploadify/upload.do', //后台处理路径
	        'method': "POST", //传递方式
	        'fileSizeLimit':"10MB",
	        "queueSizeLimit":3,
	        'fileTypeExts': '*.jpg;*.jpeg;*.gif;*.png;*.doc;*.docx;*.xls;*.xlsx;*.pdf',
	        'uploadLimit': 5,//允许更改的次数;
	        'queueID':'hid',
	        'buttonText':'上传附件',
	        'onUploadSuccess': function (file, data, response) {
	        	var data1 = JSON.parse(data);
	        	if(response){
	        		var a=$(".spans").length;
        			if(a>=3){
        				alert("最大上传三个文件")
        				return;
        				
        			}
	        		//var url=platform.appRoot+"/static/upload/"+file.name;
	        			$(".adjunct").append("<span fileUrl="+data1.Url+" class='spans' style='color:#8dbde3;margin-left:40px;'>"+file.name+"</span>" +
		        				"<a class='del' href='javascript:void(0)' style='color:#8dbde3;padding-left:40px;'>" +
		        				"[删除]</a></br>");
	        			
	        	}
	        }
	     });
	//  上传文件删除
	     $(document).on("click",".del",function(){
	    	 $(this).next().remove();
		    	$(this).prev().remove();
		    	$(this).remove();
	 		 var swfu = $('#uploadfiles').data('uploadify');
		         var stats = swfu.getStats();
		         stats.successful_uploads--;
		         swfu.setStats(stats);
		    });
		
	})
	
</script>
</html>