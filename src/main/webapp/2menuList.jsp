<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@page import="java.util.List"%>
<%@page import="com.mo.biz.menu.menuVO"%>
<%
	String businessNum = (String) session.getAttribute("businessNum");
	String grade = (String) session.getAttribute("grade");
	
	List<menuVO> menuList = (List) request.getAttribute("menuList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<a href="http://localhost:8080/biz/2menuInsert.jsp">메뉴등록</a><br>
	<%for(menuVO list:menuList){ %>
	<%=list.getMenuName() %>
	<br>
	<%} %>
</body>
</html>