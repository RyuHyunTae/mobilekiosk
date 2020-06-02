<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="http://localhost:8080/biz/shop/join.do" method="post">
		<table>
			<tr>
				<td>사업자 번호</td>
				<td><input type="text" name="businessNum"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" name="password"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>가게명</td>
				<td><input type="text" name="shopName"></td>
			</tr>
			<tr>
				<td>가게주소</td>
				<td><input type="text" name="shopAddress"></td>
			</tr>
			<tr>
				<td>가게운영시간</td>
				<td><input type="text" name="shopTime"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="회원가입"></td>
			</tr>
		</table>
	</form>
</body>
</html>