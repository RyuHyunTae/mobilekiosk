<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="java.io.File, java.util.UUID" %>
    <%@ page import="java.awt.image.BufferedImage, javax.imageio.ImageIO" %>
    <%@ page import="com.google.zxing.qrcode.QRCodeWriter, com.google.zxing.common.BitMatrix, com.google.zxing.BarcodeFormat, com.google.zxing.client.j2se.MatrixToImageWriter" %>
    <%
    	String url = request.getParameter("url");
    	String businessNum = request.getParameter("businessNum");
    	String qrcode="";
    	int nCheck = 1;
    	String savedFileName = "";
    	
    	//url 확인
    	if(url ==null || url.equals("")||!url.startsWith("http")){
    		nCheck = 0;
    	}
    	else{
    		//파일설정
    		File path = new File("C:\\Users\\HyunTae\\eclipse-workspace\\mobile\\src\\main\\webapp\\img");
    		savedFileName = UUID.randomUUID().toString().replace("-", "");
    		if(!path.exists()) path.mkdir();
    		
    		//QR코드생성
    		QRCodeWriter writer = new QRCodeWriter();
    		BitMatrix qrCode = writer.encode(url, BarcodeFormat.QR_CODE, 200, 200);
    		
    		BufferedImage qrImage = MatrixToImageWriter.toBufferedImage(qrCode);
    		ImageIO.write(qrImage, "PNG", new File(path, savedFileName+".png"));
    	}
    	
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	if(nCheck ==1){
		qrcode = "http://192.168.64.157:8080/biz/img/"+savedFileName+".png";
		out.print("<img src='"+qrcode+"'/><p/>");
	}
	else
	{
		out.print("잘못됨");
	}
%>
<form action="http://192.168.64.157:8080/biz/admin/qrcodeInsert.do" method="post">
	<input type="hidden" name="QRcode" value="<%=url%>">
	<input type="hidden" name="QRpicture" value="<%=qrcode%>">
	<input type="hidden" name="businessNum" value="<%=businessNum%>">
	<input type="submit" value="승인">
</form>
</body>
</html>