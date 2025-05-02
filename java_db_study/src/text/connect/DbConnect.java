package text.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {
	public static void main(String[] args) {

		// データベースに接続（try-with-resources文を使用）
		try (Connection con = DriverManager.getConnection(
		        "jdbc:mariadb://localhost/java_db", //URL  MAMPの場合は"localhost:8889"としてください
		        "root",//ユーザー名 
		        "" //パスワード  MAMPの場合は"root"を代入してください
		)) {
			System.out.println("データベース接続成功");
			System.out.println(con);
		} catch (SQLException e) {
			System.out.println(
			        "データベース接続失敗：" + e.getMessage());
		}
	}
}



//接続
//Connection 変数名 = DriverManager.getConnection(
//	    [URL], [ユーザー名], [パスワード]
//	);


//ユーザー名・パスワードのように、重要な情報をコードに直接記述するのは推奨されません。悪意のあるユーザーに盗み見られるリスクが高まります。
//
//そのため実際のソフトウェア開発では、以下のような手段でユーザー名やパスワードを取得するのが一般的です。
//
//外部ファイルから読み込む
//ユーザー自身に入力を要求する（Scannerクラスなどを使う）


//データベース接続が不要になったら解除が必要
//実際には、tryブロックの終了時にclose()メソッドが自動で呼び出され、データベース接続が解除されます。
//そのため、try-with-resources文ならclose()メソッドを省略可能です。


