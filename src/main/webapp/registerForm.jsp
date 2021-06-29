<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録情報の入力</title>
</head>
<body>
<form action="/tcu_gourmet/SignupUserServlet" method="post">
名前：<input type="text" name="name"><br>
ユーザID：<input type="text" name="userID"><br>
メールアドレス：<input type="text" name="email"><br>
パスワード：<input type="password" name="pass"><br>
<input type="submit" value="確認">
</form>
</body>
</html>