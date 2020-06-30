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
	<form action="http://localhost:8080/biz/shop/join.do" method="post">
		<table style="font-family: 'Nanum Brush Script', cursive; font-size: 20px;">
			<tr>
				<td>사업자 번호</td>
				<td><input type="text" name="businessNum" class="form-control"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" name="password" class="form-control"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" class="form-control"></td>
			</tr>
			<tr>
				<td>가게명</td>
				<td><input type="text" name="shopName" class="form-control"></td>
			</tr>
			<tr>
				<td>가게주소</td>
				<td><input type="text" name="shopAddress" class="form-control"></td>
			</tr>
			<tr>
				<td>가게운영시간</td>
				<td><input type="text" name="shopTime" class="form-control"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="회원가입" class="btn btn-outline-secondary"></td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>