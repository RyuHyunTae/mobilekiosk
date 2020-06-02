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
			<td>사업자 번호</td>
			<td><%=approvalDetail.getBusinessNum()%></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><%=approvalDetail.getName()%></td>
		</tr>
		<tr>
			<td>가게명</td>
			<td><%=approvalDetail.getShopName()%></td>
		</tr>
		<tr>
			<td>가게주소</td>
			<td><%=approvalDetail.getShopAddress()%></td>
		</tr>
		<tr>
			<td>가게운영시간</td>
			<td><%=approvalDetail.getShopTime()%></td>
		</tr>
		<form action="../qrcode.jsp" method="post">
			<tr>
				<td><input type="text" name="url"><input type="hidden" name="businessNum" value="<%=approvalDetail.getBusinessNum()%>"></td>
				<td><input type="submit" value="전송"></td>
			</tr>
		</form>
	</table>
</body>
</html>