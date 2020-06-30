<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>

<link
	href="http://fonts.googleapis.com/earlyaccess/nanumbrushscript.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

<body style="margin: 50px 300px">
	<div align="center">
		<form action="http://192.168.64.157:8080/biz/shop/login.do"
			method="post">
			<table style="font-family: 'Nanum Brush Script', cursive; font-size: 20px;">
				<tr>
					<td>사업자 번호</td>
					<td><input type="text" name="businessNum" class="form-control"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="password" class="form-control"></td>
				</tr>
			</table>
			<br>
			<input type="submit" value="로그인" class="btn btn-outline-secondary">
		</form>
		<br>
		<button
			onclick="location.href='http://192.168.64.157:8080/biz/2join.jsp'" class="btn btn-outline-secondary">회원가입</button>
	</div>
</body>
</html>