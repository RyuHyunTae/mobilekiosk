<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@page import="com.mo.biz.menu.menuVO" %>
<%
	String businessNum = (String) session.getAttribute("businessNum");
	String grade = (String) session.getAttribute("grade");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<a href="http://localhost:8080/biz/shop/logout.do">로그아웃</a>
	<a href="http://localhost:8080/biz/menu/list.do?businessNum=<%=businessNum%>">메뉴정보</a>
</body>
</html>