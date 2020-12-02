<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
  <link rel="stylesheet" href="../theme.css">
</head>

<body>
  <nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container"> <a class="navbar-brand" href="#">
        <i class="fa d-inline fa-lg fa-stop-circle"></i>
        <b>Cake House後台管理系統</b>
    </a> <button class="navbar-toggler navbar-toggler-right border-0" type="button" data-toggle="collapse" data-target="#navbar10">
        <span class="navbar-toggler-icon"></span>
    </button>
        <div class="collapse navbar-collapse" id="navbar10">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item"> <a class="nav-link" href="user-list.html">使用者管理</a> </li>
            <li class="nav-item"> <a class="nav-link" href="../news/list.html">最新消息管理</a> </li>
            <li class="nav-item"> <a class="nav-link" href="../products/list.html">產品管理</a> </li>
          </ul>
        </div>
    </div>
</nav>

  <div class="text-center py-3">
    <div class="container">
      <div class="row">
        <div class="col-md-12 p-3">
          <h1 class="mb-0 text-left">使用者管理</h1>
        </div>
      </div>
      <div class="row">
        <div class="col-md-12">
          <ul class="breadcrumb">
            <li class="breadcrumb-item"> <a href="#">首頁</a> </li>
            <li class="breadcrumb-item active">使用者管理</li>
          </ul>
        </div>
      </div>
    </div>
  </div>
  <div class="pb-5">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <a href="list.html" class="btn btn-sm btn-primary my-3">回列表</a>
          
          
            <form action="insert" method="post" class="justify-content-center">
         
            
                新增使用者
            
            </h2>

              <input type="hidden" name="id" value="" />

            <div class="form-group"> <label>使用者名稱</label> <input type="text" class="form-control" name="name" placeholder="輸入使用者名稱" value=""> </div>
            <div class="form-group"> <label>E-mail</label> <input type="email" class="form-control" name="email" placeholder="輸入 email" value=""> </div>
            <div class="col-md-12 d-flex justify-content-end">
           
           
               	<input type="hidden" class="form-control" name="updated_at" value="">	 	
            
               		 <input type="hidden" class="form-control" name="created_at" value="">	 
             
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