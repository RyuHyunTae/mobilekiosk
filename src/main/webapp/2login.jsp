<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="http://localhost:8080/biz/shop/login.do" method="post">
	<input type="text" name="businessNum">
	<input type="password" name="password">
	<input type="submit" value="로그인">
</form>
<button onclick="location.href='2join.jsp'">회원가입</button>
</body>
</html>