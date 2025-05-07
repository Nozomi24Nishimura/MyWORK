package text.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbSelect {

	// Javaアプリケーションで実行によって起動可能
	public static void main(String args[]) {

		// データベース接続情報
		final String URL = "jdbc:mariadb://localhost/java_db"; // MAMPの場合は"localhost:8889"としてください
		final String USER_NAME = "root";
		final String PASSWORD = ""; // MAMPの場合は"root"を代入してください

		// SELECT文のフォーマット
		String sql = "SELECT id, name FROM users;";

		try (Connection con = DriverManager
		        .getConnection(URL, USER_NAME, PASSWORD);
		        Statement statment = con
		                .createStatement()) {

			// sqlの実行 データを取得する際はResultSetを使う
			ResultSet result = statment.executeQuery(sql);

			while (result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");

				System.out.println(result.getRow()
				        + "件名:id=" + id + "/name=" + name);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}}






//try-with-resources文
//
//	try(
//
//	リソース型 変数名1 = 初期化処理1;←リソースを宣言し、
//	同時に初期化するための書き方 リソース型 変数名2=初期化処理2;
//	// ...
//	リソース型 変数名N = 初期化処理N)
//	{
//		// リソースを使った処理
//	}catch(
//	例外型1 変数名)
//	{
//		// 例外型1に対する処理
//	}catch(
//	例外型2 変数名)
//	{
//		// 例外型2に対する処理
//		// ...
//	}finally
//	{
//		// (省略可能) tryブロックやcatchブロックの後に必ず実行される処理
//}
//
//リソース型:これは、あなたが扱いたいリソースのクラス名やインターフェース名が入ります。
//例えば、
//ファイル操作であれば java.io.BufferedReader やjava.io.FileWriter、
//データベース接続であれば java.sql.Connection、
//ステートメントであれば java.sql.Statement などです

