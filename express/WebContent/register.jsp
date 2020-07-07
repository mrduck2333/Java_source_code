<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>登陆界面</title>
 <link rel="stylesheet" type="text/css" href="css/login.css" /> 
  <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" /> 
<style>
 
</style>
</head>
<body>
<div id="snow">
<h3 style="text-align: center;">注册界面</h3>
  <div class="container" style="margin:100px auto;width: 400px;color:#FFF">
  		
        <form action="RegisterServlet" method="post" onsubmit="return checkForm()">
	      <div class="form-group">
	        <label for="user">用户名</label>
	        <input type="text" name="username" onblur="checkUserName(this.value)" class="form-control" id="user" placeholder="请输入用户名"/>
	      	<span id="msg"></span>
	      </div>
	      
	      <div class="form-group">
	        <label for="password">密码</label>
	        <input type="password" name="password" class="form-control" id="password" placeholder="请输入密码"/>
	      </div>
	      
	      
	      <hr/>
	      <div class="form-group" style="text-align: center;">
	        <input class="btn btn btn-primary" type="submit"  style="width:370px" value="注册">
		  </div>
	  	</form>
		<a href="login.jsp" class="btn btn btn-primary" style="width:370px">去登录</a>
	
	  	<!-- 提示框 -->
	  	<div>
		${message }
		</div>
  	</div>
</div>
<script src="js/jquery-2.1.0.min.js"></script>
<script src="js/bootstrap.min.js"></script>


<script>
var xmlHttp;
var flag;
function createXMLHttp(){
if (window.XMLHttpRequest) {
	xmlHttp = new XMLHttpRequest();//Chrome
    } else {
    // code for IE6, IE5
     xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
}
}
function checkUserName(username){
	createXMLHttp();
	xmlHttp.open("POST", "CheckServlet?username="+username);
	xmlHttp.onreadystatechange =checkUserNameCallback;
	xmlHttp.send(null);
	document.getElementById("msg").innerHTML="正在验证...";
		
		
}

function checkUserNameCallback(){
	  if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
			 var text=xmlHttp.responseText;
			 if(text=="true"){
				 flag=false;
				 document.getElementById("msg").innerHTML="用户已经存在，请换一个用户"
			 }else{
				 flag=true;
				 document.getElementById("msg").innerHTML="可以注册";
			 }
		   //document.getElementById("demo").innerHTML = xmlHttp.responseText;
		  }
}
function checkForm(){
	return flag;
}

</script>
</body>
</html>