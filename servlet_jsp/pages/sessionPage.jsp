<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session</title>
</head>
<body>

<%--http://localhost:8080/servlet_jsp/session--%>

	<%
	//セッションデータの取得
	String cartItem = (String) session.getAttribute("cartItem");
	%>

	<h3>
		【jsp】カートに入った商品は<%=cartItem%></h3>

	<p>
		セッションID:<%=session.getId()%></p>


	<%--Servletへの画面遷移(Post) --%>

	<form action="<%=request.getContextPath()%>/session" method="post">
		<input type="submit" value="ServletへPOST送信">
	</form>
	
	
</body>
</html>