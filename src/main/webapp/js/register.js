$(document).ready(function() {
	$('#username').blur(function() {
		if ($(this).val() == "" || $(this).val() == "请输入用户名") {
			$(this).next().text("请输入用户名").css("color", "red");
		} else if ($(this).val().length < 4) {
			$(this).next().text("用户名至少为四位").css("color", "red");
		} else {
			$(this).next().empty();
		}
	});

	$('#password').blur(function() {
		var reg = /^[0-9a-zA-Z]{4,8}$/;
		if ($(this).val() == "" || $(this).val() == "请输入密码") {
			$(this).siblings(".err").text("密码不能为空").css("color", "red");
		} else if (!reg.test($(this).val())) {
			$(this).siblings(".err").text("密码为4-8位不含特殊字符").css("color", "red");
		} else {
			$(this).siblings(".err").empty();
		}
	});

	$('#sec_password').blur(function() {
		if ($(this).val() != $('#password').val()) {
			$(this).next().text("密码不一致").css("color", "red");
		} else {
			$(this).next().empty();
		}
	});

	$(".passwd-eye-icon").bind("click",function(event){
		if($(this).hasClass("glyphicon-eye-close")){
			$(this).removeClass("glyphicon-eye-close").addClass("glyphicon-eye-open");
			document.getElementById("password").type="text";
		}
		else{
			$(this).removeClass("glyphicon-eye-open").addClass("glyphicon-eye-close");
			document.getElementById("password").type="password";
		}
		//阻止事件冒泡
		event.stopPropagation();
	});
});