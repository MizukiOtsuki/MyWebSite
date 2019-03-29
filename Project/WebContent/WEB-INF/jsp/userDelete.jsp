<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>ユーザ削除画面</title>
  <!-- BootstrapのCSS読み込み -->
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <!-- オリジナルCSS読み込み -->
  <link href="css/original/common.css" rel="stylesheet">

</head>
<body>

  <!-- header -->
  <header>
    <nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0">
      <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="userDeleteServlet">削除確認</a>
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

  <form action="userDeleteServlet" method="post">

  <input type="hidden" name="id" value="${userDetail.id}">


      <p>${userDetail.loginId}を消去しますか？</p>

      <div class="col-xs-4">
        <input type="button" name="submit1" class="btn btn-light" value="いいえ" onclick="location.href='userListServlet'">
         <input type="submit" name="submit2" class="btn btn-primary" value="はい">
      </div>

    </form>


  </div>
</div>





</body>
</html>
