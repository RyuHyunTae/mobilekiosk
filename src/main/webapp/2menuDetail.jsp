<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@page import="com.mo.biz.menu.menuVO"%>
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
<link href="http://fonts.googleapis.com/earlyaccess/nanumbrushscript.css" rel="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
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
			href="http://192.168.64.157:8080/biz/menu/list.do?businessNum=<%=businessNum%>">�޴�����</a>
		<a
			href="http://192.168.64.157:8080/biz/shop/todayCalculate.do?businessNum=<%=businessNum%>">����ȭ��</a>
		<a href="http://192.168.64.157:8080/biz/shop/logout.do">�α׾ƿ�</a>
		</div>
	</nav>
	
	<div><img
				src="http://192.168.64.157:8080/biz/img/<%=menuDetail.getMenuPicture()%>" width="250" height="250"></div>
	
	<table style="font-family: 'Nanum Brush Script', cursive;">
		<tr>

			<td>�޴���</td>
			<td><%=menuDetail.getMenuName()%></td>
		</tr>
		<tr>
			<td>�޴�����</td>
			<td><%=menuDetail.getMenuDescription()%></td>
		</tr>
		<tr>
			<td>�޴�ī�װ�</td>
			<td><%=menuDetail.getMenuCategory()%></td>
		</tr>
		<tr>
			<td>�޴�����</td>
			<td><%=menuDetail.getMenuPrice()%></td>
		</tr>
		<tr>
			<td></td><td><a
				href="http://192.168.64.157:8080/biz/menu/update.do?menuNum=<%=menuDetail.getMenuNum()%>">����</a>
			<a
				href="http://192.168.64.157:8080/biz/menu/delete.do?menuNum=<%=menuDetail.getMenuNum()%>&businessNum=<%=businessNum%>">����</a></td>
		</tr>
	</table>

</body>
</html>