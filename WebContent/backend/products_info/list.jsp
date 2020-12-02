<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
  <div class="text-center py-2">
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
          <a href="<%=request.getContextPath()%>/product/new" class="btn btn-primary btn-sm my-3">新增</a>
          <div class="table-responsive">
            <table class="table table-bordered ">
              <thead class="thead-dark">
                <tr>
                  <th>商品圖</th>
                  <th>商品編號</th>
                  <th>商品名稱</th>
                  <th>庫存量</th>
                  <th>建立時間</th>
                  <th>修改時間</th>
                  <th>操作</th>
                </tr>
              </thead>
              <tbody>
          <c:choose>
              <c:when test="${totalrows > 0}">
              <c:forEach var="product" items="${listProduct}">
                <tr>
                  <th><img width="200" src="<%=request.getContextPath()%>/upload/<c:out value="${product.picture}" />"/></th>                             
                  <td><c:out value="${product.products_id}" /></td>
                  <td><c:out value="${product.products_name}" /></td>
                  <td><c:out value="${product.stock}" /></td>
                  <td><c:out value="${product.created_at}" /></td>
                  <td><c:out value="${product.updated_at}" /></td>
                  <td style=""><a class="btn btn-link p-0" href="edit?products_id=<c:out value='${product.products_id}'/>">編輯</a>&nbsp;&nbsp;&nbsp;
                  <a class="btn btn-link p-0" onclick="return confirm('確定刪除此筆資料?刪除後無法回復')" href="delete?products_id=<c:out value='${product.products_id}'/>">刪除</a></td>
                </tr>
               </c:forEach>
               </c:when>
              <c:otherwise>
              	<tr>
              	<td colspan="4">目前無資料，請新增一筆</td>
              	</tr>
              </c:otherwise>
			  </c:choose>
              </tbody>
            </table>
          </div>
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