package psj;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PracticeCookieServlet extends HttpServlet {

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		//文字コード設定
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		//cookieでデータを格納
		Cookie cId=new Cookie("cId","samurai001");
		Cookie cName=new Cookie("cName","侍太郎");
		
		//JSPにデータを渡すためにresponseにデータを格納
		response.addCookie(cId);
		response.addCookie(cName);
		
		
		//cookieの有効期限を設定　ブラウザが削除を行う
		int time=60;  //60秒
		cId.setMaxAge(time);
		
		// JSPへの画面遷移
		RequestDispatcher dispatcher=request.getRequestDispatcher("/pages/index.jsp");
		dispatcher.forward(request,response);
		
		
		
	}
}
