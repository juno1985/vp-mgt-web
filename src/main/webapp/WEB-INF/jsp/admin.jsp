<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/mgt/css/bootstrap.min.css">
<!-- 引入jQuery文件 -->
<script type="text/javascript" src="/mgt/js/jquery.min.js"></script>
<script type="text/javascript" src="/mgt/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/mgt/js/pc_admin.js"></script>
<script type="text/javascript" src="/mgt/js/jquery.form.js"></script>
<script type="text/javascript" src="/mgt/js/jquery.cookie.js"></script>
<title>后台管理</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<nav class="navbar navbar-default navbar-static-top"
				role="navigation">
				<div class="container-fluid">
					<div class="navbar-header">
						<a class="navbar-brand" href="#">后台管理系统</a>
					</div>
					<div>
					
						<ul class="nav navbar-nav  navbar-right">
							<li class="disabled"><a id="welcome_user"></a></li>
							<li class="active"><a href="/mgt/logout" class="link-logout">退出登录</a></li>
						</ul>
					</div>
				</div>
			</nav>
		</div>
		<div class="row">
			<div class="col-md-2">
				<div class="panel-group table-responsive" role="tablist">
					<div id="pcMenu" class="panel panel-primary leftMenu">
						<!-- 利用data-target指定要折叠的分组列表 -->
						<div class="panel-heading" id="collapseListGroupHeading1"
							data-toggle="collapse" data-target="#collapseListGroup1"
							role="tab">
							<h4 class="panel-title">
								商品管理 <span class="glyphicon glyphicon-chevron-up right"></span>
							</h4>
						</div>
						<!-- .panel-collapse和.collapse标明折叠元素 .in表示要显示出来 -->
						<div id="collapseListGroup1" class="panel-collapse collapse in"
							role="tabpanel" aria-labelledby="collapseListGroupHeading1">
							<ul class="list-group">
								<li class="list-group-item"><a href="javascript:void(0);"
									onClick="pc_list(1,5)">商品列表</a></li>
								<li class="list-group-item"><a href="javascript:void(0);"
									onClick="pc_add(this)" value="/mgt/page/pc_add.html">添加商品</a></li>
							</ul>
						</div>
					</div>
					<!--panel end-->
					<div id="userMenu" class="panel panel-primary leftMenu">
						<div class="panel-heading" id="collapseListGroupHeading2"
							data-toggle="collapse" data-target="#collapseListGroup2"
							role="tab">
							<h4 class="panel-title">
								员工管理 <span class="glyphicon glyphicon-chevron-down right"></span>
							</h4>
						</div>
						<div id="collapseListGroup2" class="panel-collapse collapse"
							role="tabpanel" aria-labelledby="collapseListGroupHeading2">
							<ul class="list-group">
								<li class="list-group-item"><a href="javascript:void(0);"
									onclick="user_list()">员工列表</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-1"></div>
			<div class="col-md-8" id="mgt_content"></div>
		</div>
	</div>
</body>
</html>