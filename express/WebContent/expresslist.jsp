<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
<title>信大物流管理系统</title>
<link rel="stylesheet" href="<%=basePath%>css/index.css" />
</head>
<body>
<div ng-controller="headerController" class="header stark-components navbar-fixed ng-scope">
    <nav class="white nav1">
        <div class="nav-wrapper">
            <a href="<%=basePath%>goods/homeGoods" class="logo">
                <em class="em1">信大</em>
                <em class="em2">物流管理系统</em>
                <em class="em3" style="color:red;">总共:${count}条物流信息</em>
            </a>
            <ul class="right">
                             <li> <a href="addExpress.jsp">添加物流信息</a></li>
                                <li> <a href="javascript:void(0)">欢迎${username}登陆</a></li>
                                   <li><a href="<%=path %>/UserServlet?method=LoginOutAct" target="_blank">退出登陆</a></li>
                         
            </ul>
        </div>
    </nav>
</div>
<br>
<br>
<div>
<form action="ExpressServlet?method=findByEnoAct" method="post">
<input type="text" name="eno" placeholder="根据物流订单号"/>
<input type="submit" value="查询" class="btn btn-success"/>
</form>

<br>
              <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                  <tr>
                 <!--    <th>序号</th> -->
                    <th>物流订单号</th>
                    <th>车辆车牌号</th>
                    <th>车辆拉货物品</th>
                     <th>始发地</th>
                      <th>目的地</th>
                    <th>运费</th>
                    	<th>发货时间</th>
                    <th>快递员</th>
                    <th>操作</th>
                   
                  </tr>
                </thead>
               
                <tbody>
                <c:forEach var="e" items="${list}">
                  <tr>
                    <%-- <td>${e.id }</td> --%>
                    <td>${e.eno}</td>
                    <td>${e.carno}</td>
                       <td>${e.goods}</td>
                    <td>${e.isStartLocation}</td>
                    <td>${e.isEndLocation}</td>
                    <td>${e.price }</td>
                     <td>${e.createTime}</td>
                    <td>${e.expresser}</td>
                  
                    <td><a href="ExpressServlet?method=QueryByIdAct&id=${e.id}" class="btn btn-primary">修改</a>
                    <a href="javascript:deleteExpress(${e.id});" class="btn btn-danger">删除 </a>
                    </td>
                    
                  </tr>
                  </c:forEach>
 </tbody>
              </table>
            </div>
          </div>
          ${message}
       
  
<ul class="pagination" style="float:right;">
   <li class="disabled"><a href="">共${recordCount}页 </a> </li>
 <c:if test="${pageNos>1 }">
    <li><a href="ExpressServlet?method=ExpressListAct&pageNos=1">首页</a></li>
 	<li><a href="ExpressServlet?method=ExpressListAct&pageNos=${pageNos-1 }">上一页</a></li>
  </c:if>
  <c:if test="${pageNos <recordCount }">
    <li><a href="ExpressServlet?method=ExpressListAct&pageNos=${pageNos+1 }">下一页</a></li>
    <li><a href="ExpressServlet?method=ExpressListAct&pageNos=${recordCount }">末页</a></li>
    </c:if>

    <li><form action="ExpressServlet?method=ExpressListAct" method="post">
<input type="text" value="" name="pageNos"style="height:30px; width:50px;" />
<input type="submit" value="到达" class="btn btn-success" /></form></li>
    
</ul>
  </div>

<script>
function deleteExpress(id){
    //用户安全提示
    if(confirm("您确定要删除吗？")){
        //访问路径
        location.href="${pageContext.request.contextPath}/ExpressServlet?method=DelExpressAct&id="+id;
    }
}
</script>

   
<!-- Bootstrap core JavaScript-->
  <script src="<%=path %>/js/jquery-2.1.0.min.js"></script>
  <script src="<%=path %>/static/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="<%=path %>/static/jquery-easing/jquery.easing.min.js"></script>

  <!-- Page level plugin JavaScript-->
  <script src="<%=path %>/static/chart.js/Chart.min.js"></script>
 
  <script src="<%=path %>/static/datatables/dataTables.bootstrap4.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="<%=path %>/js/sb-admin.min.js"></script>
 <script src="<%=path %>/js/bootstrap.min.js"></script>

  <!-- Demo scripts for this page-->
  <script src="<%=path %>/js/demo/datatables-demo.js"></script>
  <script src="<%=path %>/js/demo/chart-area-demo.js"></script>

      
</body>
</html>