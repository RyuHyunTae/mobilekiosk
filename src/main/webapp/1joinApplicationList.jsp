<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import="java.util.List"%>
<%@page import="com.mo.biz.shop.shopVO"%>
<%
	List<shopVO> approvalList = (List) request.getAttribute("approvalList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%for(shopVO list:approvalList){%>
	<a href="http://192.168.64.157:8080/biz/admin/approvalDetail.do?businessNum=<%=list.getBusinessNum()%>"><%=list.getBusinessNum() %></a>
	<%} %>
</body>
</html>