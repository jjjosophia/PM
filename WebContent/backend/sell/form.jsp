<%@ page import="java.io.*,java.util.*, javax.servlet.*" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
  <style>
    <%@include file="../theme.css"%>
  </style>
</head>

<body>
 <%@include file="../navbar/navbar.jsp"%>
  <div class="text-center py-3">
    <div class="container">
      <div class="row">
        <div class="col-md-12 p-3">
          <h1 class="mb-0 text-left">出貨管理</h1>
        </div>
      </div>
      <div class="row">
        <div class="col-md-12">
          <ul class="breadcrumb">
            <li class="breadcrumb-item"> <a href="#">首頁</a> </li>
            <li class="breadcrumb-item active">出貨管理</li>
          </ul>
        </div>
      </div>
    </div>
  </div>
  <div class="pb-5">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <a href="<%=request.getContextPath()%>/sell/list" class="btn btn-sm btn-primary my-3">回列表</a>
           <c:if test="${sell != null}">
            <form action="./update" method="post" class="justify-content-center">
          </c:if>
          <c:if test="${sell == null}">
            <form action="./insert" method="post" class="justify-content-center">
          </c:if>            
               <c:if test="${sell != null}">
                <h2 class="my-2">編輯出貨單</h2>
              </c:if>
              <c:if test="${sell == null}">
               <h2 class="my-2">新增出貨單</h2>
              </c:if>               
            <!--<div class="form-group"> <label>出貨單編號</label> <input type="text" class="form-control" name="id" placeholder="輸入出貨單編號" value="${sell.id}"> </div>-->
            <div class="form-group"> <label>購物平台編號</label> <input type="text" class="form-control" name="shop_id" placeholder="輸入購物平台編號" value="${sell.shop_id}"> </div>
            <div class="form-group"> <label>購物平台訂單編號</label> <input type="text" class="form-control" name="shop_sell_id" placeholder="輸入購物平台訂單編號" value="${sell.shop_sell_id}"> </div>
            <div class="form-group"> <label>商品編號</label> <input type="text" class="form-control" name="products_id" placeholder="輸入商品編號" value="${sell.products_id}"> </div>
            <div class="form-group"> <label>售價</label> <input type="text" class="form-control" name="products_price" placeholder="輸入售價" value="${sell.products_price}"> </div>
            <div class="form-group"> <label>銷售數量</label> <input type="text" class="form-control" name="sell_qty" placeholder="輸入銷售數量" value="${sell.sell_qty}"> </div>
            <div class="form-group"> <label>訂單狀態</label> <input type="text" class="form-control" name="sell_status" placeholder="輸入訂單狀態" value="${sell.sell_status}"> </div>
            <div class="col-md-12 d-flex justify-content-end">
  			<%
  			
  			java.util.Date dt = new java.util.Date();

  			java.text.SimpleDateFormat sdf = 
  			     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  			String currentTime = sdf.format(dt);
  			
  			%>
            <c:if test="${sell != null}">
               	<input type="hidden" class="form-control" name="updated_at" value="<%= currentTime%>">	 	
              </c:if>
              
              <c:if test="${sell == null}">
                 <input type="hidden" class="form-control" name="created_at" value="<%= currentTime%>">	 
              </c:if>   
              <input type="hidden" class="form-control" name="id" value="<c:out value='${sell.id}'/>">          
              <button type="submit" class="btn btn-primary d-inline-flex">確定送出</button>
            </div> 
            </form>         
        </div>
      </div>
    </div>
  </div>
  <div class="py-3">
    <div class="container">
      <div class="row">
        <div class="col-md-12 text-center">
          <p class="mb-0">© 2014-2018 MacroViz. All rights reserved</p>
        </div>
      </div>
    </div>
  </div>
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>   
</body>

</html>