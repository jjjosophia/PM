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
          <h1 class="mb-0 text-left">商品管理</h1>
        </div>
      </div>
      <div class="row">
        <div class="col-md-12">
          <ul class="breadcrumb">
            <li class="breadcrumb-item"> <a href="#">首頁</a> </li>
            <li class="breadcrumb-item active">商品管理</li>
          </ul>
        </div>
      </div>
    </div>
  </div>
  <div class="pb-5">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <a href="<%=request.getContextPath()%>/product/list" class="btn btn-sm btn-primary my-3">回列表</a>
           <c:if test="${product != null}">
            <form action="./update" method="post" class="justify-content-center" enctype="multipart/form-data">
          </c:if>
          <c:if test="${product == null}">
            <form action="./insert" method="post" class="justify-content-center" enctype="multipart/form-data">
          </c:if>            
               <c:if test="${product != null}">
                <h2 class="my-2">編輯產品</h2>
              </c:if>
              <c:if test="${product == null}">
               <h2 class="my-2">新增產品</h2>
              </c:if>         
              <c:if test="${product != null}">
              <input type="hidden" name="products_id" value="<c:out value='${product.products_id}' />" />
              <input type="hidden" name="old_picture" value="<c:out value='${product.picture}' />" />
            </c:if>
            <div class="form-group"> <label>商品圖</label> 
            
            <img id="show_img" class="mb-3" src="<%=request.getContextPath()%>/upload/<c:out value="${product.picture}" />" />
            
            <input type="file" class="form-control" name="picture"> </div>
            <div class="form-group"> <label>商品編號</label> <input type="text" class="form-control" name="products_id" placeholder="輸入商品編號" value="${product.products_id}"> </div>
            <div class="form-group"> <label>商品名稱</label> <input type="text" class="form-control" name="products_name" placeholder="輸入商品名稱" value="${product.products_name}"> </div>
            <div class="form-group"> <label>庫存量</label> <input type="text" class="form-control" name="stock" placeholder="輸入庫存量" value="${product.stock}"> </div>
            <div class="col-md-12 d-flex justify-content-end">
  			
  			<%
  			
  			java.util.Date dt = new java.util.Date();

  			java.text.SimpleDateFormat sdf = 
  			     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  			String currentTime = sdf.format(dt);
  			
  			%>
            <c:if test="${product != null}">
               	<input type="hidden" class="form-control" name="updated_at" value="<%= currentTime%>">	 	
              </c:if>
              
              <c:if test="${product == null}">
                 <input type="hidden" class="form-control" name="created_at" value="<%= currentTime%>">	 
              </c:if>
              <input type="hidden" class="form-control" name="products_id" value="<c:out value="${product.products_id}"/>">
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
  <script src="https://cdn.ckeditor.com/4.15.0/standard/ckeditor.js"></script>
<script>
    CKEDITOR.replace( 'description' );
   $(function(){
	   $("input[name='picture']").change(function(){
	        $("#show_img").attr("src",URL.createObjectURL($(this)[0].files[0]));
	    });
   });
 </script>  
</body>

</html>