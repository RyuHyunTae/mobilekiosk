<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%
	String businessNum = (String) session.getAttribute("businessNum");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="http://localhost:8080/biz/menu/insert.do" method="post">
	<input type="text" name="menuName">
	<textarea rows="30" cols="30" name="menuDescription"></textarea>
	<input type="text" name="menuPrice">
	<input type="hidden" name="menuPicture" value="1">
	<input type="hidden" name="busniessNum" value="<%=businessNum%>">
	<input type="submit" value="등록">
	</form>
</body>
</html>