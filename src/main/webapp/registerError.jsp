<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String errorMsg = (String)session.getAttribute("errorMsg");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=errorMsg %>
<br>
<a href="/tcu_gourmet/SignupUserServlet">戻る</a>

</body>
</html>