<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import="com.mo.biz.menu.menuVO" %>
    <%
    menuVO menuDetail = (menuVO) request.getAttribute("menuDetail");
    String supplier_business_number = (String) session.getAttribute("supplier_business_number");
	String supplier_name = (String) session.getAttribute("supplier_name");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="http://localhost:8080/biz/menu/update.do" method="post">
	<input type="text" name="menuName" value="<%=menuDetail.getMenuName()%>">
	<textarea rows="30" cols="30" name="menuDescription"><%=menuDetail.getMenuDescription() %></textarea>
	<input type="text" name="menuPrice" value="<%=menuDetail.getMenuPrice()%>">
	<input type="hidden" name="menuPicture" value="1">
	<input type="hidden" name="busniessNum" value="1">
	<input type="hidden" name="menuNum" value="<%=menuDetail.getMenuNum()%>">
	<input type="submit" value="수정">
	</form>
</body>
</html>