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
				<td>����� ��ȣ</td>
				<td><input type="text" name="businessNum"></td>
			</tr>
			<tr>
				<td>��й�ȣ</td>
				<td><input type="text" name="password"></td>
			</tr>
			<tr>
				<td>�̸�</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>���Ը�</td>
				<td><input type="text" name="shopName"></td>
			</tr>
			<tr>
				<td>�����ּ�</td>
				<td><input type="text" name="shopAddress"></td>
			</tr>
			<tr>
				<td>���Կ�ð�</td>
				<td><input type="text" name="shopTime"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="ȸ������"></td>
			</tr>
		</table>
	</form>
</body>
</html>