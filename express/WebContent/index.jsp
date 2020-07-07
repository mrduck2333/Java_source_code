<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>欢迎界面</title>
 <link rel="stylesheet" href="<%=basePath%>css/index.css" />
</head>
<body>
<div ng-controller="headerController" class="header stark-components navbar-fixed ng-scope">
    <nav class="white nav1">
        <div class="nav-wrapper">
            <a href="<%=basePath%>goods/homeGoods" class="logo">
                <em class="em1">信大</em>
                <em class="em2">物流管理系统</em>
                <em class="em3" style="color:red;">源码客栈版权所有：需要定制开发此类源码请加我QQ:1728608455,更多源码微信搜索：关注"源码客栈"公众号</em>
            </a>
          
            <ul class="right">
              
                              
                            
                      
                                <li><a href="login.jsp" target="_blank">登录后台</a></li>
                                <li><a href="register.jsp">注册</a></li>
                         
            </ul>
        </div>
    </nav>
</div>
<div style="margin:0 auto; margin-left:180px;">
 <img src="img/xinda.jpg"  />
</div>
</body>
</html>