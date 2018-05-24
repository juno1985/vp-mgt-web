<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理用户注册</title>
<link rel="stylesheet"
	href="/mgt/css/bootstrap.min.css">
	<link rel="stylesheet"
	href="/mgt/css/register.css">
<!-- 引入jQuery文件 -->
<script type="text/javascript"
	src="/mgt/js/jquery.min.js"></script>
<script type="text/javascript"
	src="/mgt/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="/mgt/js/register.js"></script>
</head>
<body>
<div class="container" style="margin-top:150px">
	<form class="col-md-offset-4 col-md-4 col-md-offset-4 form form-horizontal" action="http://localhost:8003/auth-api/register" method="post" id="login_form">
		<h3 class="text-center">用户注册</h3>
		<div class="form-group">
			<label for="username" class="col-md-2 control-label">帐&nbsp;号:</label>
			<div class="col-md-10">
				<input type="text" class="form-control" id="username" name="username" placeholder="请输入用户名">
				<span class="err"></span>
			</div>
		</div>
		
		<div class="form-group">
			<label for="password" class="col-md-2 control-label">密&nbsp;码:</label>
			<div class="col-md-10">
				<input type="password" class="form-control" id="password" name="password" placeholder="请输入密码">
				<span class="glyphicon glyphicon-eye-close passwd-eye-icon"></span>
				<span class="err"></span>
			</div>
		</div>
		
		<div class="form-group">
			<label for="sec_password" class="col-md-2 control-label">密&nbsp;码:</label>
			<div class="col-md-10">
				<input type="password" class="form-control" id="sec_password" name="sec_password" placeholder="再次输入密码">
				<span class="err"></span>
			</div>
		</div>
		
		<button type="submit" class="btn btn-success center-block">注册</button>
	</form>
</div>
</body>
</html>