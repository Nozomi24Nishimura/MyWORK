package text.connect;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbInsertDbInsert {

	public static void main(String[] args) {

		// データベース接続情報
		final String URL = "jdbc:mariadb://localhost/java_db"; // MAMPの場合は"localhost:8889"としてください
		final String USER_NAME = "root";
		final String PASSWORD = ""; // MAMPの場合は"root"を代入してください

		// Insert文 フォーマット
		String sql = "INSERT INTO users(name,age) VALUES (?,?);";

		// 追加するデータ
		// ユーザーの氏名リスト
		String[] names = { "侍一郎", "侍花子", "侍二郎", "侍寺子",
		        "侍三郎" };
		// ユーザーの年齢リスト
		int[] ages = { 28, 24, 26, 37, 21 };

		// DB接続と、SQL文の送信準備
		try (java.sql.Connection con = DriverManager
		        .getConnection(URL, USER_NAME, PASSWORD);
		        PreparedStatement statement = con
		                .prepareStatement(sql);) {

			int row = 0;
			for (int i = 0; i < names.length; i++) {
				
				//sqlの「？」にループで値を入れて一件ずつ追加
				statement.setString(1, names[i]);// 名前
				statement.setInt(2, ages[i]);// 年齢

				// SQL文を実行（DBMSに送信）
				System.out.println("レコード追加:" + statement.toString());
				row += statement.executeUpdate();
			}

			System.out.println(row + "件のレコードが追加されました");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

//レコード1件を追加　構文
//INSERT INTO テーブル名 (カラム1, カラム2, ...) VALUES (値1, 値2, ...);



//レコード複数件を追加　構文
//INSERT INTO テーブル名 (カラム1, カラム2, ...) VALUES
//(値1-1, 値1-2, ...),
//(値2-1, 値2-2, ...),
//・・・・・・
//(値N-1, 値N-2, ...);



//文字列データ（String型）に置き換える場合
//statement.setString(置き換える?の番号, 置き換えるデータ);

//整数データ（int型）に置き換える場合
//statement.setInt(置き換える?の番号, 置き換えるデータ);