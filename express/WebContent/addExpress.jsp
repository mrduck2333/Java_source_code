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
<title>添加物流信息</title>

  <link href="<%=path %>/static/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <!-- Page level plugin CSS-->
  <link href="<%=path %>/static/datatables/dataTables.bootstrap4.css" rel="stylesheet">
  <!-- Custom styles for this template-->
  <link href="<%=path %>/css/sb-admin.css" rel="stylesheet">
</head>
<body>
  
  <div class="container">
    <div class="card card-login mx-auto mt-5">
      <div class="card-header">信大物流信息</div>
      
      <div class="card-body">
        <form  action="ExpressServlet?method=AddExpressAct" method="post">
        <input type="hidden" name="id"  />
          <div class="form-group">
          <label for="expressno">物流订单编号</label>
            <div class="form-label-group">
              <input type="text" id="eno" name="eno" class="form-control" placeholder="请输入用户名" required="required" autofocus="autofocus">
              
            </div>
          </div>
          <div class="form-group">
            <label for="ename">车辆车牌号</label>
            <div class="form-label-group">
              <input type="text" id="carno" name="carno"  class="form-control" placeholder="请输入车辆车牌号" required="required">
            
            </div>
          </div>
          
           <div class="form-group">
            <label for="ename">物流物品信息</label>
            <div class="form-label-group">
              <input type="text" id="goods" name="goods"  class="form-control" placeholder="请输入物流拉货物品" required="required">
            
            </div>
          </div>
          
          
            <div class="form-group">
            <label for="isStartLocation">始发地</label>
            <div class="form-label-group">
              <input type="text" id="isStartLocation" name="isStartLocation"  class="form-control" placeholder="请输入密码" required="required">
            
            </div>
          </div>
          
           <div class="form-group">
            <label for="isEndLocation">终点站</label>
            <div class="form-label-group">
              <input type="text" id="isEndLocation" name="isEndLocation"  class="form-control" placeholder="请输入密码" required="required">
            
            </div>
          </div>
          
          <div class="form-group">
            <label for="price">物流运费</label>
            <div class="form-label-group">
              <input type="text" id="price" name="price"  class="form-control" placeholder="请输入密码" required="required">
            
            </div>
          </div>
          
           <div class="form-group">
            <label for="createTime">发货日期</label>
            <div class="form-label-group">
              <input type="date" id="createTime" name="createTime"  class="form-control" placeholder="请输入密码" required="required">
            
            </div>
          </div>
          
            <div class="form-group">
            <label for="expresser">快递员</label>
            <div class="form-label-group">
              <input type="text" id="expresser" name="expresser"  class="form-control" placeholder="请输入密码" required="required">
            
            </div>
          </div>
       
         <input type="submit" class="btn btn-primary btn-block" value="立即添加"></a>
        
        </form>
        <br>
        <div class="text-center">
          <a class="btn btn-success btn-block" href="ExpressServlet?method=ExpressListAct">返回首页</a>
        </div>
      </div>
    </div>
  </div>


  <script src="<%=path %>/static/jquery/jquery.min.js"></script>
  <script src="<%=path %>/static/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="<%=path %>/static/jquery-easing/jquery.easing.min.js"></script>

  <!-- Page level plugin JavaScript-->

  <script src="<%=path %>/static/datatables/jquery.dataTables.js"></script>
  <script src="<%=path %>/static/datatables/dataTables.bootstrap4.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="<%=path %>/js/sb-admin.min.js"></script>

  <!-- Demo scripts for this page-->
  <script src="<%=path %>/js/demo/datatables-demo.js"></script>
  <script src="<%=path %>/js/demo/chart-area-demo.js"></script>


</body>
</html>