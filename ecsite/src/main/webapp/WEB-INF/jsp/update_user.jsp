<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報変更画面</title>
<link rel = 'stylesheet' type = 'text/css' href = 'css/shop_style.css' />
</head>
<body>
	<h3>会員情報</h3>
	<br/>
	<form action = 'UpdateUserServlet' method = 'POST'>
		<table>
			<tr>
				<th>会員ID</th>
				<td>${userId}</td>
				<input type = 'hidden' class = 'id' name = 'userId' value = ${userId} />
			</tr>
			<tr>
				<th>お名前</th>
				<td><input type = 'text' class = 'id' name = 'name' value = ${name} /></td>
			</tr>
			<tr>
				<th>パスワード</th>
				<td><input type = 'password' class = 'password' name = 'password1' /></td>
			</tr>
			<tr>
				<th>パスワード（確認）</th>
				<td><input type = 'password' class = 'password' name = 'password2' /></td>
			</tr>
			<tr>
				<th>ご住所</th>
				<td><input type = 'text' class = 'id' name = 'address' value = ${address} /></td>
			</tr>
			<tr>
				<td colspan = '2'><input type = 'submit' value = '変更' /></td>
			</tr>
		</table>
	</form>
	<br/>
	<a href = "/ecsite/WithdrawConfirmServlet">退会する</a><br/><br/>
	<a href = "/ecsite/PurchaseHistoryServlet">購入履歴</a>へ<br/>
	<a href = "/ecsite/MainServlet">商品検索</a>へ
</body>
</html>