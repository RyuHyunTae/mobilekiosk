<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@page import="java.util.List"%>
<%@page import="com.mo.biz.menu.menuVO"%>
<%
	String businessNum = (String) session.getAttribute("businessNum");
	String grade = (String) session.getAttribute("grade");

	List<menuVO> menuList = (List) request.getAttribute("menuList");
	String qrcode = (String) request.getAttribute("qrcode");
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
	<div>
		<a href="http://192.168.64.157:8080/biz/2menuInsert.jsp">메뉴등록</a><br>
		<img src="<%=qrcode%>">
		<table style="font-family: 'Nanum Brush Script', cursive;">
		<tr>
			<td>메뉴명</td>
			<td>가격</td>
			<td>카테고리</td>
		</tr>
			<%
				for (menuVO list : menuList) {
			%>
			<tr>
				<td><a
					href="http://192.168.64.157:8080/biz/menu/detail.do?menuNum=<%=list.getMenuNum()%>"><%=list.getMenuName()%></a>
				</td>
				<td>
					<%=list.getMenuPrice() %>
				</td>
				<td>
					<%=list.getMenuCategory() %>
				</td>
			</tr>
			<%
				}
			%>
		</table>

	</div>
</body>
</html>