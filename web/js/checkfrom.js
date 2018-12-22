$(document).ready(function(){	
	alert(1);
	$("form").submit(function(e){
		var usernameJQ = $("#username");
		var pwdJQ = $("#pwd");
		var repwdJQ = $("#repwd");
			
		if (!isPassword($("input[name=pwd]").val())) {
			e.preventDefault();
		}
		$("span").html('<font></font>');
		if(usernameJQ.val() == ""|| usernameJQ.val()=="请输入账号" ){
			$("#error").html('<font style="color:red;font-size:10px"><b>&nbsp账号不能为空</b></font>');
			e.preventDefault();
		}
		if(pwdJQ.val() == ""){
			$("#error").html('<font style="color:red;font-size:10px"><b>&nbsp密码不能为空</b></font>');
			e.preventDefault();
		}else if(pwdJQ.val() != repwdJQ.val()){
			$("#error").html('<font style="color:red;font-size:10px"><b>&nbsp两次输入密码不一致</b></font>');
			e.preventDefault();
		}
	});

	function isPassword(str){
		//var reg = /[a-z0-9]/;
		//alert(/[^a-z0-9A-Z]/.test(str));
		if(!/^[A-Z]/.test(str)){
			// document.getElementById("pwderror").innerHTML='<font style="color:red;font-size:10px"><b>&nbsp第一位必须是大写字母</b></font>';	
			$("#error").html('<font style="color:red;font-size:10px"><b>&nbsp第一位必须是大写字母</b></font>');
			return false;
		}else if(str.length<6){
			// document.getElementById("pwderror").innerHTML='<font style="color:red;font-size:10px"><b>&nbsp密码长度不能小于6</b></font>';
			$("#error").html('<font style="color:red;font-size:10px"><b>&nbsp密码长度不能小于6</b></font>');
			return false;	
		}if (/[^a-z0-9A-Z_!*#]/.test(str)) {
			// document.getElementById("pwderror").innerHTML='<font style="color:red;font-size:10px"><b>&nbsp密码只能包含数字、_、!、*、#和大小写字母</b></font>';
			$("#error").html('<font style="color:red;font-size:10px"><b>&nbsp密码只能包含数字、_、!、*、#和大小写字母</b></font>');
			return false;
		}
		return true;
	}
};