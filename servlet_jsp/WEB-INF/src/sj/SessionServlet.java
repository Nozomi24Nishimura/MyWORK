package sj;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,
	        HttpServletResponse response)
	        throws ServletException, IOException {

		// リクエスト、レスポンスの設定
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; chaeset=UTF-8");

		// セッションの取得 存在しなければ新規に開始
		HttpSession session = request.getSession();

		// セッションデータへの登録
		session.setAttribute("cartItem", "コーヒー");

		// セッションのタイムアウト設定
//		session.setMaxInactiveInterval(30);

		
		
//		web.xmlでも管理できる
//		<session-config>
//	    <session-timeout>10</session-timeout>
//		</session-config>

		// JSPに画面遷移
		RequestDispatcher dispatcher = request
		        .getRequestDispatcher(
		                "/pages/sessionPage.jsp");
		dispatcher.forward(request, response);
	}

	public void doPost(HttpServletRequest request,
	        HttpServletResponse response)
	        throws IOException {

		// リクエスト、レスポンスの設定
		// リクエスト・レスポンスの設定
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		// セッションの取得 存在しなければ新規に開始
		HttpSession session = request.getSession();

		// セッションデータの取得
		String cartItem = (String) session
		        .getAttribute("cartItem");

		PrintWriter out = response.getWriter();

//		if (cartItem == null) { // 有効なデータが存在しない場合
//			out.println(
//			        "<h3>【Servlet：doPost()】カートに商品が入っていません</h3>");
//		} else {
//			out.println("<h3>【Servlet：doPost()】カートに入った商品は"
//			        + cartItem + "</h3>");
//		}

		out.println("<h3>【Servlet：doPost()】カートに入った商品は"
		        + cartItem + "</h3>");

		out.println(
		        "<p>セッションID：" + session.getId() + "</p>");

		// セッション終了
		session.invalidate();

		// 30秒経過したことでセッションタイムアウトが発生し、前のセッションデータが失われます。
		// 実際に、セッションIDも変わっていますね。
		

	}
}