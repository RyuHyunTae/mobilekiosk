<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@page import="java.util.List"%>
<%@page import="com.mo.biz.shop.calculateVO"%>
<%
	List<calculateVO> todayCalculate = (List) request.getAttribute("todayCalculate");
	String businessNum = (String) session.getAttribute("businessNum");
	int all=0;
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
	<div>
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
		<div>
			<form action="http://192.168.64.157:8080/biz/shop/preCalculate.do"
				method="get">
				<input type="text" name="orderTime" placeholder="0000-00"> <input
					type="hidden" name="businessNum" value="<%=businessNum%>">
				<input type="submit" value="�˻�" class="btn btn-outline-secondary">
			</form>
		</div>
	</div>
	<div>
		<table style="font-family: 'Nanum Brush Script', cursive;">
			<tr>
				<td>�ֹ���ȣ</td>
				<td>�ֹ��ð�</td>
				<td>�ֹ��� ID</td>
				<td>�� ����</td>
			</tr>
			<%
				for (calculateVO today : todayCalculate) {
			%>
			<tr>
				<td><%=today.getOrderNum()%></td>
				<td><%=today.getOrderTime()%></td>
				<td><%=today.getId()%></td>
				<td><%=today.getOrderTotalPrice()%></td>
			</tr>

			<%
				all = all + today.getOrderTotalPrice();
				}
			%><tr>
				<td colspan="3" style="text-align: right;">�� �ݾ� :</td>
				<td><%=all%></td>
			</tr>
		</table>
	</div>
</body>
</html>