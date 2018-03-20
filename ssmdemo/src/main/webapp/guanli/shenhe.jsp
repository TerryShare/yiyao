<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%> 
<html lang="en">
<head>
<meta charset="utf-8" />
<title>社区快速送药系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<!-- basic styles -->
<link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/font-awesome.min.css" />
<!--[if IE 7]>
		  <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
		<![endif]-->

<!-- page specific plugin styles -->

<!-- fonts -->

<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Open+Sans:400,300" />

<!-- ace styles -->

<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace-rtl.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/font-awesome.min.css" />

<!--[if lte IE 8]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->

<!-- inline styles related to this page -->

<!-- ace settings handler -->

<script src="${pageContext.request.contextPath}/assets/js/ace-extra.min.js"></script>

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

<!--[if lt IE 9]>
		<script src="assets/js/html5shiv.js"></script>
		<script src="assets/js/respond.min.js"></script>
		<![endif]-->
		
		<style>
		.wrap-inner-goods, .wrap-inner-goodss {
   			 border: 1px solid #9A948E;
    		 width: 45%;
    		 height: 40%;
    		 background: #fff;
    		 position: fixed;
    		 left: 30%;
    		 top: 10%;
			}
		
		</style>
</head>

<body>
	<div class="navbar navbar-default" id="navbar" style="height:40px">
		

		<div class="navbar-container" id="navbar-container">
			<div class="navbar-header pull-left">
				<a href="#" class="navbar-brand"> <small> <i
						class="icon-leaf"></i> 社区快速送药系统
				</small>
				</a>
				<!-- /.brand -->
			</div>
			<!-- /.navbar-header -->

			<div class="navbar-header pull-right" role="navigation">
				<ul class="nav ace-nav">
					<li class="light-blue"><a data-toggle="dropdown" href="tc.do"
						class="dropdown-toggle"> <span class="user-info"> 
						<small><a href="tc.do">退出</a></small>
						</span>
					</a></li>
				</ul>
				
			</div>
			
		</div>
		
	</div>

	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed')
			} catch (e) {
			}
		</script>

		<div class="main-container-inner">
			<a class="menu-toggler" id="menu-toggler" href="#"> <span
				class="menu-text"></span>
			</a>

			<div class="sidebar" id="sidebar">
				<script type="text/javascript">
					try {
						ace.settings.check('sidebar', 'fixed')
					} catch (e) {
					}
				</script>

				<div class="sidebar-shortcuts" id="sidebar-shortcuts">
					<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
						<button class="btn btn-success">
							<i class="icon-signal"></i>
						</button>

						<button class="btn btn-info">
							<i class="icon-pencil"></i>
						</button>

						<button class="btn btn-warning">
							<i class="icon-group"></i>
						</button>

						<button class="btn btn-danger">
							<i class="icon-cogs"></i>
						</button>
					</div>

					<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
						<span class="btn btn-success"></span> <span class="btn btn-info"></span>

						<span class="btn btn-warning"></span> <span class="btn btn-danger"></span>
					</div>
				</div>
				<!-- #sidebar-shortcuts -->

			<ul class="nav nav-list">
					<li><a href="ckss.do"> <i class="icon-dashboard"></i>
							<span class="menu-text">留言管理</span>
					</a></li>
				</ul>
				<ul class="nav nav-list">
					<li><a href="tzsh.do"> <i class="icon-dashboard"></i>
							<span class="menu-text">审核管理</span>
					</a></li>
				</ul>
				<ul class="nav nav-list">
					<li><a href="yhgltz.do"> <i class="icon-dashboard"></i>
							<span class="menu-text">用户管理</span>
					</a></li>
				</ul>
				<ul class="nav nav-list">
					<li><a href="ypgl.do"> <i class="icon-dashboard"></i>
							<span class="menu-text">药品管理</span>
					</a></li>
				</ul>
				<!-- /.nav-list -->

				<div class="sidebar-collapse" id="sidebar-collapse">
					<i class="icon-double-angle-left"
						data-icon1="icon-double-angle-left"
						data-icon2="icon-double-angle-right"></i>
				</div>

				<script type="text/javascript">
					try {
						ace.settings.check('sidebar', 'collapsed')
					} catch (e) {
					}
				</script>
			</div>

			<div class="main-content">
				<div class="breadcrumbs" id="breadcrumbs">
					<script type="text/javascript">
						try {
							ace.settings.check('breadcrumbs', 'fixed')
						} catch (e) {
						}
					</script>

					
					<!-- .breadcrumb -->

					
					<!-- #nav-search -->
				</div>

				<div class="page-content">
					<div class="page-header">
						<h1>
							审核管理 <small> <i class="icon-double-angle-right"></i> 
							</small>
						</h1>
					</div>
					<!-- /.page-header -->

					<div class="row">
						<div class="col-xs-12">
							<!-- PAGE CONTENT BEGINS -->
							 <table style="margin-left:20px;  display:none;" id="ystable">
							 <thead>
							 <tr><td style="background-color:blue"><span  class="yssh">医师审核</span></td>
							 	<td><span class="ypsh">药品审核</span></td>
							 </tr>
       <tr style="text-align:center;">
      
           <td ><span style="width:100px;display:inline-block;word-wrap:break-word;">姓名</span></td>
           <td ><span style="width:100px;display:inline-block;word-wrap:break-word;">文件一</span></td>
           <td ><span style="width:100px;display:inline-block;word-wrap:break-word;">文件二</span></td>
           <td ><span style="width:100px;display:inline-block;word-wrap:break-word;">文件三 </span></td>
           <td>通过</td>
           <td>作废</td>
       </tr>
       			</thead>
       			 <tbody id="sideber_a"  style="text-align:center;">
       				
       			 </tbody>
       			
       </table>
       <table style="margin-left:20px;" id="yptable">
							 <thead>
							 <tr><td><span class="yssh">医师审核</span></td>
							 	<td style="background-color:blue"><span  class="ypsh">药品审核</span></td>
							 </tr>
       <tr style="text-align:center;">
      
           <td ><span style="width:100px;display:inline-block;word-wrap:break-word;">名字</span></td>
           <td ><span style="width:100px;display:inline-block;word-wrap:break-word;">商家</span></td>
           <td ><span style="width:100px;display:inline-block;word-wrap:break-word;">分类</span></td>
           <td ><span style="width:100px;display:inline-block;word-wrap:break-word;">价格</span></td>
           <td ><span style="width:100px;display:inline-block;word-wrap:break-word;">数量 </span></td>
           <td ><span style="width:100px;display:inline-block;word-wrap:break-word;">状态 </span></td>
           <td>通过</td>
           <td>作废</td>
          
       </tr>
       			</thead>
       			 <tbody id="sideber_b"  style="text-align:center;">
       				
       			 </tbody>
       			
       </table>

					<a href="#" id="btn-scroll-up"
								class="btn-scroll-up btn btn-sm btn-inverse"> <i
								class="icon-double-angle-up icon-only bigger-110"></i>
							</a>
						</div>
						<!-- /.main-container -->

						<!-- basic scripts -->

						<!--[if !IE]> 

						<script
							src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
-->
						<!-- <![endif]-->

						<!--[if IE]>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<![endif]-->

						<!--[if !IE]> -->

						<script type="text/javascript">
							window.jQuery
									|| document
											.write("<script src='${pageContext.request.contextPath}/assets/js/jquery-2.0.3.min.js'>"
													+ "<"+"script>");
						</script>

						<!-- <![endif]-->

						<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='assets/js/jquery-1.10.2.min.js'>"+"<"+"script>");
</script>
<![endif]-->

						<script type="text/javascript">
							if ("ontouchend" in document)
								document
										.write("<script src='assets/js/jquery.mobile.custom.min.js'>"
												+ "<"+"script>");
						</script>
						<script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
						<script src="${pageContext.request.contextPath}/assets/js/typeahead-bs2.min.js"></script>

						<!-- page specific plugin scripts -->

						<!--[if lte IE 8]>
		  <script src="assets/js/excanvas.min.js"></script>
		<![endif]-->

						<script src="${pageContext.request.contextPath}/assets/js/jquery-ui-1.10.3.custom.min.js"></script>
						<script src="${pageContext.request.contextPath}/assets/js/jquery.ui.touch-punch.min.js"></script>
						<script src="${pageContext.request.contextPath}/assets/js/jquery.slimscroll.min.js"></script>
						<script src="${pageContext.request.contextPath}/assets/js/jquery.easy-pie-chart.min.js"></script>
						<script src="${pageContext.request.contextPath}/assets/js/jquery.sparkline.min.js"></script>
						<script src="${pageContext.request.contextPath}/assets/js/flot/jquery.flot.min.js"></script>
						<script src="${pageContext.request.contextPath}/assets/js/flot/jquery.flot.pie.min.js"></script>
						<script src="${pageContext.request.contextPath}/assets/js/flot/jquery.flot.resize.min.js"></script>
						<script src="${pageContext.request.contextPath}/assets/js/template-web.js"></script>
						<!-- ace scripts -->

						<script src="${pageContext.request.contextPath}/assets/js/ace-elements.min.js"></script>
						<script src="${pageContext.request.contextPath}/assets/js/ace.min.js"></script>

						<!-- inline scripts related to this page -->

						<script type="text/javascript">
							jQuery(function($) {
								$('.easy-pie-chart.percentage')
										.each(
												function() {
													var $box = $(this).closest(
															'.infobox');
													var barColor = $(this)
															.data('color')
															|| (!$box
																	.hasClass('infobox-dark') ? $box
																	.css('color')
																	: 'rgba(255,255,255,0.95)');
													var trackColor = barColor == 'rgba(255,255,255,0.95)' ? 'rgba(255,255,255,0.25)'
															: '#E2E2E2';
													var size = parseInt($(this)
															.data('size')) || 50;
													$(this)
															.easyPieChart(
																	{
																		barColor : barColor,
																		trackColor : trackColor,
																		scaleColor : false,
																		lineCap : 'butt',
																		lineWidth : parseInt(size / 10),
																		animate : /msie\s*(8|7|6)/
																				.test(navigator.userAgent
																						.toLowerCase()) ? false
																				: 1000,
																		size : size
																	});
												})

								$('.sparkline')
										.each(
												function() {
													var $box = $(this).closest(
															'.infobox');
													var barColor = !$box
															.hasClass('infobox-dark') ? $box
															.css('color')
															: '#FFF';
													$(this)
															.sparkline(
																	'html',
																	{
																		tagValuesAttribute : 'data-values',
																		type : 'bar',
																		barColor : barColor,
																		chartRangeMin : $(
																				this)
																				.data(
																						'min') || 0
																	});
												});

								var placeholder = $('#piechart-placeholder')
										.css({
											'width' : '90%',
											'min-height' : '150px'
										});
								var data = [ {
									label : "social networks",
									data : 38.7,
									color : "#68BC31"
								}, {
									label : "search engines",
									data : 24.5,
									color : "#2091CF"
								}, {
									label : "ad campaigns",
									data : 8.2,
									color : "#AF4E96"
								}, {
									label : "direct traffic",
									data : 18.6,
									color : "#DA5430"
								}, {
									label : "other",
									data : 10,
									color : "#FEE074"
								} ]
								function drawPieChart(placeholder, data,
										position) {
									$.plot(placeholder, data, {
										series : {
											pie : {
												show : true,
												tilt : 0.8,
												highlight : {
													opacity : 0.25
												},
												stroke : {
													color : '#fff',
													width : 2
												},
												startAngle : 2
											}
										},
										legend : {
											show : true,
											position : position || "ne",
											labelBoxBorderColor : null,
											margin : [ -30, 15 ]
										},
										grid : {
											hoverable : true,
											clickable : true
										}
									})
								}
								drawPieChart(placeholder, data);

								/**
								we saved the drawing function and the data to redraw with different position later when switching to RTL mode dynamically
								so that's not needed actually.
								 */
								placeholder.data('chart', data);
								placeholder.data('draw', drawPieChart);

								var $tooltip = $(
										"<div class='tooltip top in'><div class='tooltip-inner'></div></div>")
										.hide().appendTo('body');
								var previousPoint = null;

								placeholder.on('plothover', function(event,
										pos, item) {
									if (item) {
										if (previousPoint != item.seriesIndex) {
											previousPoint = item.seriesIndex;
											var tip = item.series['label']
													+ " : "
													+ item.series['percent']
													+ '%';
											$tooltip.show().children(0).text(
													tip);
										}
										$tooltip.css({
											top : pos.pageY + 10,
											left : pos.pageX + 10
										});
									} else {
										$tooltip.hide();
										previousPoint = null;
									}

								});

								var d1 = [];
								for (var i = 0; i < Math.PI * 2; i += 0.5) {
									d1.push([ i, Math.sin(i) ]);
								}

								var d2 = [];
								for (var i = 0; i < Math.PI * 2; i += 0.5) {
									d2.push([ i, Math.cos(i) ]);
								}

								var d3 = [];
								for (var i = 0; i < Math.PI * 2; i += 0.2) {
									d3.push([ i, Math.tan(i) ]);
								}

								var sales_charts = $('#sales-charts').css({
									'width' : '100%',
									'height' : '220px'
								});
								$.plot("#sales-charts", [ {
									label : "Domains",
									data : d1
								}, {
									label : "Hosting",
									data : d2
								}, {
									label : "Services",
									data : d3
								} ], {
									hoverable : true,
									shadowSize : 0,
									series : {
										lines : {
											show : true
										},
										points : {
											show : true
										}
									},
									xaxis : {
										tickLength : 0
									},
									yaxis : {
										ticks : 10,
										min : -2,
										max : 2,
										tickDecimals : 3
									},
									grid : {
										backgroundColor : {
											colors : [ "#fff", "#fff" ]
										},
										borderWidth : 1,
										borderColor : '#555'
									}
								});

								$('#recent-box [data-rel="tooltip"]').tooltip({
									placement : tooltip_placement
								});
								function tooltip_placement(context, source) {
									var $source = $(source);
									var $parent = $source
											.closest('.tab-content')
									var off1 = $parent.offset();
									var w1 = $parent.width();

									var off2 = $source.offset();
									var w2 = $source.width();

									if (parseInt(off2.left) < parseInt(off1.left)
											+ parseInt(w1 / 2))
										return 'right';
									return 'left';
								}

								$('.dialogs,.comments').slimScroll({
									height : '300px'
								});

								//Android's default browser somehow is confused when tapping on label which will lead to dragging the task
								//so disable dragging when clicking on label
								var agent = navigator.userAgent.toLowerCase();
								if ("ontouchstart" in document
										&& /applewebkit/.test(agent)
										&& /android/.test(agent))
									$('#tasks')
											.on(
													'touchstart',
													function(e) {
														var li = $(e.target)
																.closest(
																		'#tasks li');
														if (li.length == 0)
															return;
														var label = li.find(
																'label.inline')
																.get(0);
														if (label == e.target
																|| $
																		.contains(
																				label,
																				e.target))
															e
																	.stopImmediatePropagation();
													});

								$('#tasks').sortable({
									opacity : 0.8,
									revert : true,
									forceHelperSize : true,
									placeholder : 'draggable-placeholder',
									forcePlaceholderSize : true,
									tolerance : 'pointer',
									stop : function(event, ui) {//just for Chrome!!!! so that dropdowns on items don't appear below other items after being moved
										$(ui.item).css('z-index', 'auto');
									}
								});
								$('#tasks').disableSelection();
								$('#tasks input:checkbox')
										.removeAttr('checked')
										.on(
												'click',
												function() {
													if (this.checked)
														$(this)
																.closest('li')
																.addClass(
																		'selected');
													else
														$(this)
																.closest('li')
																.removeClass(
																		'selected');
												});

							})
						</script>
						<script type="text/html" id="tplys"><!--这是定义模型的  -->
									{{each list value index}}
										<tr>
											<input type="hidden" class="ysid" value={{value.id}}>
										<td>
											{{value.name}}
										</td>
										<td>
											<a href={{value.t1}} download="文件一">文件一</a>
										</td>
										<td>
										{{if value.t2 !=""}}
											<a href={{value.t2}} download="文件二">文件二</a>
{{/if}}
										</td>
										<td>
{{if value.t2 !=""}}
											<a href={{value.t3}} download="文件三">文件三</a>
{{/if}}
										</td>
										<td><input type="button" value="通过ys" class="ystg"></td>
										<td><input type="button" value="作废ys" class="yszf"></td>
										</tr>
									{{/each}}
						</script>
						<script type="text/html" id="tplyp"><!--这是定义模型的  -->
									{{each list value index}}
										<tr>
										<input type="hidden" class="hidid" value={{value.id}}>
										<td>
											{{value.name}}
										</td>
										<td>
											{{value.t1}}
										</td>
										<td>
											{{value.t2}}
										</td>
										<td>
											{{value.price}}
										</td>
										<td>
											{{value.number}}
										</td>
										<td>
										{{if value.shangjia=="0"}}
											下架
											{{/if}}
										{{if value.shangjia=="1"}}
											上架
											{{/if}}
										</td> 
										<td><input type="button" value="通过" class="glytg"></td>
										<td><input type="button" value="作废" class="glyzf"></td>
										</tr>
									{{/each}}
						</script>
				
	<script>
	//医师
		  $.ajax({
        type: "post",
        dataType: 'json',//默认转化对象
        async:false,
        url:  "glyyscq.do", //提交到一般处理程序请求数据
        error: function(){
        	alert("请求失败,轻语管理员联系");
        },
        success: function(data) {
    		var seltpl = template('tplys', {
                list:data
            });
    		$("#sideber_a").html(seltpl);
    		
        }
    })
    //药品
     $.ajax({
        type: "post",
        dataType: 'json',//默认转化对象
        async:false,
        url:  "glyypcq.do", //提交到一般处理程序请求数据
        error: function(){
        	alert("请求失败,轻语管理员联系");
        },
        success: function(data) {
    		var seltpl = template('tplyp', {
                list:data
            });
    		$("#sideber_b").html(seltpl);
    		
        }
    })
    $(".glytg").click(function(){
    	var id=$(this).parent().parent().find(".hidid").val();
    	  $.ajax({
    	        type: "get",
    	        dataType: 'json',//默认转化对象
    	        async:false,
    	        url:  "glyyptg.do?id="+id, //提交到一般处理程序请求数据
    	        error: function(){
    	        	alert("请求失败,轻语管理员联系");
    	        },
    	        success: function(data) {
    	        	var str=data.succ;
    	        	if(str=="false"){
    	        		alert("通过失败!")
    	        	}else{
    	        		window.location.href="glyshtz.do";
    	        	}
    	    		
    	        }
    	    })
    })
    //作废
      $(".glyzf").click(function(){
    	var id=$(this).parent().parent().find(".hidid").val();
    	  $.ajax({
    	        type: "get",
    	        dataType: 'json',//默认转化对象
    	        async:false,
    	        url:  "glyypzf.do?id="+id, //提交到一般处理程序请求数据
    	        error: function(){
    	        	alert("请求失败,轻语管理员联系");
    	        },
    	        success: function(data) {
    	        	var str=data.succ;
    	        	if(str=="false"){
    	        		alert("作废失败!")
    	        	}else{
    	        		window.location.href="glyshtz.do";
    	        	}
    	    		
    	        }
    	    })
    })
   $(".yssh").click(function(){
	   $("#ystable").show();
	   $("#yptable").hide();
	   
   })
      $(".ypsh").click(function(){
	   $("#ystable").hide();
	   $("#yptable").show();
	   
   })
   //医师通过
   $(".ystg").click(function(){
	   var id=$(this).parent().parent().find(".ysid").val();
 	  $.ajax({
 	        type: "get",
 	        dataType: 'json',//默认转化对象
 	        async:false,
 	        url:  "glyytg.do?id="+id, //提交到一般处理程序请求数据
 	        error: function(){
 	        	alert("请求失败,轻语管理员联系");
 	        },
 	        success: function(data) {
 	        	var str=data.succ;
 	        	if(str=="false"){
 	        		alert("通过失败!")
 	        	}else{
 	        		window.location.href="glyshtz.do";
 	        	}
 	    		
 	        }
 	    })
   })
   //医师作废
   $(".yszf").click(function(){
	   var id=$(this).parent().parent().find(".ysid").val();
 	  $.ajax({
 	        type: "get",
 	        dataType: 'json',//默认转化对象
 	        async:false,
 	        url:  "glyyzf.do?id="+id, //提交到一般处理程序请求数据
 	        error: function(){
 	        	alert("请求失败,轻语管理员联系");
 	        },
 	        success: function(data) {
 	        	var str=data.succ;
 	        	if(str=="false"){
 	        		alert("通过失败!")
 	        	}else{
 	        		window.location.href="glyshtz.do";
 	        	}
 	    		
 	        }
 	    })
   })

	</script>
</body>
</html>

