package text.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbCreateTable {
	public static void main(String[] args) {
		// データベース接続情報
		final String URL = "jdbc:mariadb://localhost/java_db"; // MAMPの場合は"localhost:8889"としてください
		final String USER_NAME = "root";
		final String PASSWORD = ""; // MAMPの場合は"root"を代入してください

		// CREATE TABLE文のフォーマット
		String sql = """
		        CREATE TABLE users (
		          id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
		          name VARCHAR(60) NOT NULL,
		          age INT(11)
		        );
		        """;

		try (Connection con = DriverManager
		        .getConnection(URL, USER_NAME, PASSWORD);
		        Statement statment = con
		                .createStatement()) {

			// SQL文を実行（DBMSに送信）
			int rowCnt = statment.executeUpdate(sql);
			System.out.println("テーブルを作成:rowCnt=" + rowCnt);

		} catch (SQLException e) {
			System.out.println(
			        "データベース接続失敗：" + e.getMessage());
			e.printStackTrace();
		}

	}

}
