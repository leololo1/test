<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員登録完了画面</title>
<link rel = 'stylesheet' type = 'text/css' href = 'css/shop_style.css' />
</head>
<body>
	<h3>以下の会員情報で変更しました</h3>
	<br/>
	<table>
		<tr>
			<th>会員ID</th>
			<td>${userId}</td>
		</tr>
		<tr>
			<th>パスワード</th>
			<td>${password}</td>
		</tr>
		<tr>
			<th>お名前</th>
			<td>${name}</td>
		</tr>
		<tr>
			<th>ご住所</th>
			<td>${address}</td>
		</tr>
	</table>
	<br/>
	<a href = "/ecsite/MainServlet">商品検索</a>へ<br/>
</body>
</html>