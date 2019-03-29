<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>ユーザ更新画面</title>
  <!-- BootstrapのCSS読み込み -->
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <!-- オリジナルCSS読み込み -->
  <link href="css/original/common.css" rel="stylesheet">

</head>
<body>

  <!-- header -->
  <header>
    <nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0">
      <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="userUpdateServlet">ユーザー情報更新</a>
      <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
          <a class="nav-link" href="logoutServlet">ログアウト</a>
        </li>
      </ul>
    </nav>
  </header>
  <!-- /header -->

  <!-- body -->
  <div class="container">


    <!-- エラーメッセージのサンプル(エラーがある場合のみ表示) -->
    <c:if test="${errMsg != null}" >

    <div class="alert alert-danger" role="alert">

    	${errMsg}

	</div>
	</c:if>


    <form method="post" action="userUpdateServlet" class="form-horizontal">

    <input type="hidden" name="id" value="${userDetail.loginId}">

      <div class="form-group row">
        <label for="loginId" class="col-sm-2 col-form-label">ログインID</label>
        <div class="col-sm-10">
          <p class="form-control-plaintext">${userDetail.loginId}</p>
        </div>
      </div>

      <div class="form-group row">
        <label for="password" class="col-sm-2 col-form-label">パスワード</label>
        <div class="col-sm-10">
          <input type="password" class="form-control" id="password" name="password">
        </div>
      </div>

      <div class="form-group row">
        <label for="passwordConf" class="col-sm-2 col-form-label">パスワード(確認)</label>
        <div class="col-sm-10">
          <input type="password" class="form-control" id="passwordConf" name="password2">
        </div>
      </div>

      <div class="form-group row">
        <label for="userName" class="col-sm-2 col-form-label">ユーザ名</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" id="userName" name="name" value="${userDetail.name}">
        </div>
      </div>

       <div class="submit-button-area">
        <button type="submit" value="検索" class="btn btn-primary btn-lg btn-block">登録</button>
      </div>

      <div class="col-xs-4">
        <a href="userListServlet">戻る</a>
      </div>

    </form>


  </div>
</div>





</body>
</html>
