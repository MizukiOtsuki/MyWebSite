<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>掲示板</title>
<!-- BootstrapのCSS読み込み -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- オリジナルCSS読み込み -->
<link href="css/original/common.css" rel="stylesheet">

</head>
<body>

	<!-- header -->
	<header>
		<nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0">
			<a class="navbar-brand col-sm-3 col-md-2 mr-0" href="boardServlet">掲示板</a>
			<ul class="navbar-nav px-3">
				<li class="nav-item text-nowrap"><a class="nav-link"
					href="logoutServlet">ログアウト</a></li>
			</ul>
		</nav>
	</header>
	<!-- /header -->

	<!-- body -->
	<div class="container">

		<h1>投稿する</h1>

		<br>
		<!-- エラーメッセージのサンプル(エラーがある場合のみ表示) -->
		<c:if test="${errMsg != null}">
			<div class="alert alert-danger" role="alert">${errMsg}</div>
		</c:if>

		<form method="post" action="boardServlet" class="form-horizontal">

			<div class="form-group row">
				<label for="title" class="col-sm-2 col-form-label">投稿タイトル：</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="title" name="title"
						placeholder="投稿タイトル">
				</div>
			</div>


			<div class="form-group row">
				<label for="ask1" class="col-sm-2 col-form-label">投稿内容：</label>
				<div class="col-sm-10">
					<textarea rows="7" class="form-control" id="ask1"
						name="postContent" placeholder="投稿内容を書く"></textarea>
				</div>
			</div>

			<div class="submit-button-area">
				<button type="submit" value="投稿"
					class="btn btn-primary btn-lg btn-block">投稿する</button>
			</div>

			<div class="col-xs-4">
				<a href="userListServlet">戻る</a>
			</div>

		</form>

		<hr>

		<h1>投稿一覧</h1>

		<br>

		<c:forEach var="list" items="${BulletinBoardList}">

			<p>
			<div class="card" style="width: 69.5rem;">
				<div class="card-header">${list.userName}</div>
				<div class="card-body">
					<h5 class="card-title">${list.title}</h5>
					<h6 class="card-text">${list.postContent}</h6>

					<form method="post" action="boardDeleteServlet" class="form-horizontal">
					<input type="hidden" name="id" value="${list.id}">
					<button type="submit" class="btn btn-outline-danger">削除</button>

					</form>

				</div>
				<div class="card-footer text-muted">${list.formatDate}</div>
			</div>

			</p>

		</c:forEach>


	</div>

	</div>





</body>
</html>
