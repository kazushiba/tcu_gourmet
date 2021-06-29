<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.User" %>
    <%
    User registerUser = (User)session.getAttribute("registerUser");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録情報の確認</title>
</head>
<body>
<p>
名前：<%=registerUser.getName() %><br>
ログインID：<%=registerUser.getUserID() %><br>
メールアドレス：<%=registerUser.getEmail() %><br>
パスワード(確認用)：<%=registerUser.getHashedPass() %><br>
管理者フラグ：<%=registerUser.isAdmin() %><br>

</p>
<a href="/tcu_gourmet/SignupUserServlet">キャンセル</a>
<a href="/tcu_gourmet/SignupUserServlet?action=done">登録</a>
</body>
</html>