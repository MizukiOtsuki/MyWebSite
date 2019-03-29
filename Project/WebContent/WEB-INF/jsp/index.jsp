<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ログイン画面</title>
    <!-- BootstrapのCSS読み込み -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- オリジナルCSS読み込み -->
    <link href="css/original/login.css" rel="stylesheet">
  </head>
  <body>

    <!-- body -->

    <c:if test="${errMsg != null}" >

		  ${errMsg}

	</c:if>


    <form class="form-signin" action="loginServlet" method="post">
      <div class="text-center mb-4">
        <img class="mb-4" src="https://getbootstrap.com/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
        <h1 class="h3 mb-3 font-weight-normal">ログイン画面</h1>
      </div>

      <div class="form-label-group">
        <input type="text" name="loginId" id="inputLoginId" class="form-control" placeholder="ログインIDを入力してください" autofocus>
        <label for="inputLoginId">ログインID</label>
      </div>

      <div class="form-label-group">
        <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password">
        <label for="inputPassword">パスワード</label>
      </div>

      <button class="btn btn-lg btn-primary btn-block" type="submit" value="ログイン">ログイン</button>
    </form>


  </body>
</html>
