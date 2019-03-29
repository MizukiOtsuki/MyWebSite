<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>ユーザ一覧画面</title>
  <!-- BootstrapのCSS読み込み -->
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <!-- オリジナルCSS読み込み -->
  <link href="css/original/common.css" rel="stylesheet">
</head>
<body>

  <!-- header -->
  <header>
    <nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0">
      <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="userListServlet">ユーザー一覧</a>
      <ul class="navbar-nav px-3">
      <li class="navbar-text">${userInfo.name} さん </li>
        <li class="dropdown">
  							<a href="logoutServlet" class="navbar-link logout-link">ログアウト</a>
        </li>
      </ul>
    </nav>
  </header>
  <!-- /header -->

  <!-- body -->
  <div class="container">

    <!-- 新規登録ボタン -->
    <div class="create-button-area">
      <a class="btn btn-outline-primary btn-lg" href="userCreateServlet">新規登録</a>
    </div>

    <div class="create-button-area">
      <a class="btn btn-outline-primary btn-lg" href="boardServlet">掲示板</a>
    </div>


    <!-- 検索ボックス -->
    <div class="search-form-area">
      <div class="panel-body">

        <form method="post" action="userListServlet" class="form-horizontal">
          <div class="form-group row">
            <label for="loginId" class="col-sm-2 col-form-label">ログインID</label>
            <div class="col-sm-10">
              <input type="text" class="form-control" id="loginId" name="loginId">
            </div>
          </div>

          <div class="form-group row">
            <label for="userName" class="col-sm-2 col-form-label">ユーザ名</label>
            <div class="col-sm-10">
              <input type="text" class="form-control" id="userName" name="name">
            </div>
          </div>


          </div>
          <div class="text-right">
            <button type="submit" value="検索" class="btn btn-primary form-submit">検索</button>
          </div>

        </form>

      </div>
    </div>

    <!-- 検索結果一覧 -->



    <div class="table-responsive">
      <table class="table table-striped">
        <thead class="thead-dark">
          <tr>
            <th>ログインID</th>
            <th>ユーザ名</th>
            <th></th>
          </tr>
        </thead>
        <tbody>

        <c:forEach var="user" items="${userList}">

          <tr>
            <td>${user.loginId}</td>
            <td>${user.name}</td>
            <td>
            <input type="button" name="submit1"  class="btn btn-primary" value="詳細" onclick="location.href='userDetailServlet?id=${user.loginId}'">

              <c:if test="${userInfo.loginId == 'mizuki' || userInfo.loginId == user.loginId}">
			<input type="button" name="submit2" class="btn btn-success" value="更新" onclick="location.href='userUpdateServlet?id=${user.loginId}'">

           </c:if>
             <c:if test="${userInfo.loginId == 'mizuki'}">

			<input type="submit" name="submit3" class="btn btn-danger" value="削除" onclick="location.href='userDeleteServlet?id=${user.loginId}'">
			</c:if>

            </td>

			 </tr>

            </c:forEach>

          <tr>

        </tbody>
      </table>
    </div>

  </div>
</div>

</body>
</html>
