<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
	String businessNum = (String) session.getAttribute("businessNum");
	String url = (String) request.getAttribute("url");
%>
<link href="http://fonts.googleapis.com/earlyaccess/nanumbrushscript.css" rel="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>

<style>
  table {
    width: 100%;
    border-top: 1px solid #444444;
    border-collapse: collapse;
  }
  th, td {
    border-bottom: 1px solid #444444;
    padding: 10px;
  }
</style>

<body style="margin: 50px 300px">

<nav>
	<div style="text-align: left;"><form action="http://192.168.64.157:8080/biz/shop/main.do" method="post">
		<input type="hidden" name="businessNum" value="<%=businessNum%>">
		<input type="submit" value="HOME" class="btn btn-outline-secondary">
	</form></div>
		<div  style="text-align: right;">
		<a
			href="http://192.168.64.157:8080/biz/menu/list.do?businessNum=<%=businessNum%>">메뉴정보</a>
		<a
			href="http://192.168.64.157:8080/biz/shop/todayCalculate.do?businessNum=<%=businessNum%>">정산화면</a>
		<a href="http://192.168.64.157:8080/biz/shop/logout.do">로그아웃</a>
		</div>
	</nav>

	<table style="font-family: 'Nanum Brush Script', cursive;">
		<form action="upload.do" method="post" enctype="multipart/form-data">
			<tr>
				<td>사진</td>
				<td><input type="file" name="file1" class="btn btn-outline-secondary"></td>
				<td><input type="submit" value="사진등록"
					class="btn btn-outline-secondary"></td>
			</tr>
		</form>

		<form action="http://192.168.64.157:8080/biz/menu/insert.do" method="post">
			<tr>
				<td>메뉴명</td>
				<td><input type="text" name="menuName"></td>
			</tr>
			<tr>
				<td>메뉴설명</td>
				<td><textarea rows="30" cols="30" name="menuDescription"></textarea></td>
			</tr>
			<tr>
				<td>메뉴가격</td>
				<td><input type="text" name="menuPrice"></td>
			</tr>
			<tr>
				<td>메뉴사진</td>
				<td><%=url%><input type="hidden" name="menuPicture" value="<%=url%>"></td>
			</tr>
			<tr>
				<td>메뉴카테고리</td>
				<td><input type="text" name="menuCategory"></td>
			</tr>
			<tr>
				<td><input type="hidden" name="businessNum"
					value="<%=businessNum%>"></td>
				<td><input type="submit" value="등록" class="btn btn-outline-secondary"></td>
			</tr>
		</form>
	</table>
</body>
</html>