<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- http://localhost:8080/cookiePractice/practice_cookie --%>
	<%
	
	//詳しくはこちらを参照→　javax.servlet.http.Cookie クラス
	
	//クッキー（cookie）とは、ブラウザ側でデータを管理する仕組みのことです。
	//セッションはサーバー側、クッキーはブラウザ側という決定的な違いがあります。
	
	
	String userId = ""; // ユーザーID
	String userName = ""; // ユーザー名

	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if ("cId".equals(cookie.getName())) {
		userId = cookie.getValue();
			}
			if ("cName".equals(cookie.getName())) {
		userName = cookie.getValue();
			}
		}
	}
	%>

	<p>
		ユーザーID：<%=userId%></p>
	<p>
		ユーザー名：<%=userName%></p>


<%--

不要になったクッキーはブラウザ側で削除します。ブラウザ側でクッキーを削除するタイミングは、主に以下の3つです。

有効期限が切れたとき（有効期限のあるクッキーのみ）
セッションが終了したとき（有効期限のないクッキーのみ）
ユーザーがブラウザ操作でクッキーを削除したとき
クッキーにも有効期限がありますが、期限の有無はデータの内容に応じて設定できます。
有効期限のあるクッキーは、期限切れになった時点でブラウザが削除するものです。


 --%>



</body>
</html>