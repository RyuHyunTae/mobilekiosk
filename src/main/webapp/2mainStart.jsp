<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@page import="com.mo.biz.order.orderListVO"%>
<%
	List<orderListVO> data = (List) request.getAttribute("data");
	String businessNum = (String) session.getAttribute("businessNum");
	String grade = (String) session.getAttribute("grade");
%>
<link
	href="http://fonts.googleapis.com/earlyaccess/nanumbrushscript.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>

<script type="text/javascript">
	window.setTimeout('window.location.reload()',2000);
</script>

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
		<div style="text-align: left;">
			<form action="http://192.168.64.157:8080/biz/shop/main.do"
				method="post">
				<input type="hidden" name="businessNum" value="<%=businessNum%>">
				<input type="submit" value="HOME" class="btn btn-outline-secondary">
			</form>
		</div>
		<div style="text-align: right;">
			<a
				href="http://192.168.64.157:8080/biz/menu/list.do?businessNum=<%=businessNum%>">메뉴정보</a>
			<a
				href="http://192.168.64.157:8080/biz/shop/todayCalculate.do?businessNum=<%=businessNum%>">정산화면</a>
			<a href="http://192.168.64.157:8080/biz/shop/logout.do">로그아웃</a>
		</div>
	</nav>

	<form action="http://192.168.64.157:8080/biz/shop/mainClose.do"
				method="post">
				<input type="hidden" name="businessNum" value="<%=businessNum%>">
				<input type="submit" value="종료" class="btn btn-outline-secondary">
			</form>
	<table style="font-family: 'Nanum Brush Script', cursive; font-size: 20px;">
		<tr>
			<td style="width: 100px;">주문 번호</td>
			<td style="width: 2500px;">메뉴 명</td>
			<td style="width: 5000px;">요청사항</td>
			<td style="width: 500px;">주문시간</td>
			<td style="width: 200px;">완료</td>
			<td style="width: 200px;">취소</td>
		</tr>
		<%
			for (int i = 0; i < data.size(); i++) {
		%>
		<%
			if (i == 0) {
		%>
		<tr>
			<td><%=data.get(i).getOrderNum()%></td>
			<td><%=data.get(i).getMenuName()%></td>
			<td><%=data.get(i).getOrderRequest() %></td>
			<td><%=data.get(i).getOrderTime() %></td>
			<td><form action="http://192.168.64.157:8080/biz/shop/orderApproval.do" method="post">
					<input type="hidden" name="businessNum" value="<%=businessNum%>">
					<input type="hidden" name="orderNum" value="<%=data.get(i).getOrderNum()%>">
					<input type="submit" value=" " class="btn btn-success" style="width: 50px;">
				</form></td>
			<td><form action="http://192.168.64.157:8080/biz/shop/orderCancel.do" method="post">
					<input type="hidden" name="businessNum" value="<%=businessNum%>">
					<input type="hidden" name="orderNum" value="<%=data.get(i).getOrderNum()%>">
					<input type="submit" value=" " class="btn btn-info" style="width: 50px;">
				</form></td>
		</tr>
		<%
			} else {
		%>
		<%
			if (data.get(i).getOrderNum() == data.get(i - 1).getOrderNum()) {
		%>
		<tr>
			<td></td>
			<td><%=data.get(i).getMenuName()%></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<%
			} else {
		%>
		</table>
		<br>
		<table style="font-family: 'Nanum Brush Script', cursive; font-size: 20px;">
		<tr>
			<td style="width: 100px;">주문 번호</td>
			<td style="width: 2500px;">메뉴 명</td>
			<td style="width: 5000px;">요청사항</td>
			<td style="width: 500px;">주문시간</td>
			<td style="width: 200px;">완료</td>
			<td style="width: 200px;">취소</td>
		</tr>
		<tr>
			<td><%=data.get(i).getOrderNum()%></td>
			<td><%=data.get(i).getMenuName()%></td>
			<td><%=data.get(i).getOrderRequest() %></td>
			<td><%=data.get(i).getOrderTime() %></td>
			<td><form action="http://192.168.64.157:8080/biz/shop/orderApproval.do" method="post">
					<input type="hidden" name="businessNum" value="<%=businessNum%>">
					<input type="hidden" name="orderNum" value="<%=data.get(i).getOrderNum()%>">
					<input type="submit" value=" " class="btn btn-success" style="width: 50px;">
				</form></td>
			<td><form action="http://192.168.64.157:8080/biz/shop/orderCancel.do" method="post">
					<input type="hidden" name="businessNum" value="<%=businessNum%>">
					<input type="hidden" name="orderNum" value="<%=data.get(i).getOrderNum()%>">
					<input type="submit" value=" " class="btn btn-info" style="width: 50px;">
				</form></td>
		</tr>
		<%
			}
		%>
		<%
			}
		%>
		<%
			}
		%>
	</table>
	
	
</body>
</html>