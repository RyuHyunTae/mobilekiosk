<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%@page import="com.mo.biz.shop.shopVO"%>
<%
	shopVO approvalDetail = (shopVO) request.getAttribute("approvalDetail");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>����� ��ȣ</td>
			<td><%=approvalDetail.getBusinessNum()%></td>
		</tr>
		<tr>
			<td>�̸�</td>
			<td><%=approvalDetail.getName()%></td>
		</tr>
		<tr>
			<td>���Ը�</td>
			<td><%=approvalDetail.getShopName()%></td>
		</tr>
		<tr>
			<td>�����ּ�</td>
			<td><%=approvalDetail.getShopAddress()%></td>
		</tr>
		<tr>
			<td>���Կ�ð�</td>
			<td><%=approvalDetail.getShopTime()%></td>
		</tr>
		<form action="../qrcode.jsp" method="post">
			<tr>
				<td><input type="text" name="url"><input type="hidden" name="businessNum" value="<%=approvalDetail.getBusinessNum()%>"></td>
				<td><input type="submit" value="����"></td>
			</tr>
		</form>
	</table>
</body>
</html>