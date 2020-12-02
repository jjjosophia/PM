<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
  <link rel="stylesheet" href="theme.css">
  <link rel="stylesheet" href="custom.css">
</head>

<body style="background-image: url('images/bg_admin.jpg'); background-size: 100% auto;">
    <div class="container py-5">
      <div class="row">
        <div class="col-md-6 mx-auto">
          <div class="card">
            <h3 class="card-title text-white text-center my-3">Cake House後台管理系統</h3>
            <div class="card-body" style="">
              <form id="c_form-h" class="" action="postLogin">
                <div class="form-group row"> <label for="inputmailh" class="col-2 col-form-label text-white">帳號</label>
                  <div class="col-10">
                    <input type="email" class="form-control" id="email" name="email" placeholder="輸入帳號"> </div>
                </div>
                <div class="form-group row"> <label for="inputpasswordh" class="col-2 col-form-label text-white">密碼</label>
                  <div class="col-10">
                    <input type="password" class="form-control" id="password" name="password" placeholder="輸入密碼"> </div>
                </div>
              </form>

              <div class="alert alert-danger text-center" role="alert">
                帳號密碼錯誤，請重新登入。
              </div>

              <div class="col-md-6 mx-auto">
                
                <a class="btn btn-link text-white" href="#" style="opacity: 0.5;">忘記密碼?</a>
                <button type="submit" class="btn btn-primary">登入</button>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="row py-4">
        <div class="mx-auto col-lg-8 col-md-10">
        </div>
      </div>
    </div>

  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" ></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>

</html>