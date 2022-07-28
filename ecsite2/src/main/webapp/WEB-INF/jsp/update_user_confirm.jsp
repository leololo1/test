<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報変更確認画面</title>
<link rel = 'stylesheet' type = 'text/css' href = 'css/shop_style.css' />
</head>
<body>
	<h3>会員情報</h3>
	<br/>
	<form action = 'UpdateUserCommitServlet' method = 'POST'>
		<table>
			<tr>
				<th>会員ID</th>
				<td>${userId}</td>
				<input type = 'hidden' class = 'id' name = 'userId' value = ${userId} />
			</tr>
			<tr>
				<th>パスワード</th>
				<td>${password}</td>
				<input type = 'hidden' class = 'password' name = 'password' value = ${password} />
			</tr>
			<tr>
				<th>お名前</th>
				<td>${name}</td>
				<input type = 'hidden' class = 'id' name = 'name' value = ${name} />
			</tr>
			<tr>
				<th>ご住所</th>
				<td>${address}</td>
				<input type = 'hidden' class = 'id' name = 'address' value = ${address} />
			</tr>
			<tr>
				<td colspan = '2'><input type = 'submit' value = '変更' /></td>
			</tr>
		</table>
	</form>
	<br/>
	<a href = "/ecsite/MainServlet">商品検索</a>へ<br/>
</body>
</html>