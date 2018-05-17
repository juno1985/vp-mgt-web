$(document).ready(function(){
	$('#username').blur(function(){
		if($(this).val()==""||$(this).val()=="请输入用户名"){
			$(this).next().text("请输入用户名").css("color","red");
		}
		else if($(this).val().length<4){
			$(this).next().text("用户名至少为四位").css("color","red");
		}
		else
		{
			$(this).next().empty();
		}
	});
	
	$('#password').blur(function(){
		var reg = /^[0-9a-zA-Z]{4,8}$/;
		if($(this).val()==""||$(this).val()=="请输入密码"){
			$(this).next().text("密码不能为空").css("color","red");
		}
		else if(!reg.test($(this).val())){
			$(this).next().text("密码为4-8位不含特殊字符").css("color","red");
		}
		else{
			$(this).next().empty();
		}
	});
	
	$('#sec_password').blur(function(){
		if($(this).val() != $('#password').val()){
			$(this).next().text("密码不一致").css("color","red");
		}
		else{
			$(this).next().empty();
		}
	});
});