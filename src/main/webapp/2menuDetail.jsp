<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
      <%@page import="com.mo.biz.menu.menuVO" %>
    <%
    menuVO menuDetail = (menuVO) request.getAttribute("menuDetail");
    String businessNum = (String) session.getAttribute("businessNum");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	
	<%=menuDetail.getMenuName()%><br>
	<%=menuDetail.getMenuDescription() %><br>
	<%=menuDetail.getMenuPrice()%><br>
	<a href="http://localhost:8080/biz/menu/update.do?menuNum=<%=menuDetail.getMenuNum()%>">수정</a>
	<a href="http://localhost:8080/biz/menu/delete.do?menuNum=<%=menuDetail.getMenuNum()%>&businessNum=<%=businessNum%>">삭제</a>
	
	
</body>
</html>