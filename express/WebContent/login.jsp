<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>登陆界面</title>
  <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" /> 
<style>

</style>
</head>
<body>

  <div class="container" style="margin:100px auto;width: 400px;color:#FFF">
  <h1 style="color:#000;">用户登陆</h1>
        <form action="UserServlet?method=LoginAct" method="post">
	      	
	        
	        <input type="text" name="username" class="form-control" id="user" placeholder="请输入用户名"/>
	  	<br>
	      
	    
	      
	        <input type="password" name="password" class="form-control" id="password" placeholder="请输入密码"/>
	    <br>
	      
	      
	     
	        <input class="btn btn btn-primary" type="submit" style="width:370px" value="登录">
		
	  	</form>
	  	  <br>
		<a href="register.jsp" class="btn btn btn-primary" style="width:370px">去注册</a>
	<br>
		${error }
  	</div>
</div>

</body>54
</html>