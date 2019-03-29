package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.BulletinBoard;



public class BulletinBoardDao {



	//掲示板投稿一覧を表示させる
	public List<BulletinBoard> findAll() {
		Connection conn = null;
		List<BulletinBoard> BulletinBoardList = new ArrayList<BulletinBoard>();

		try {
			// データベースへ接続する
			conn = DBManager.getConnection();

			// SELECT文を準備する。ユーザーの全ての情報を取得する
			String sql = "SELECT * FROM bulletin_board INNER JOIN user ON bulletin_board.user_id = user.login_id";

			// SELECTを実行し、結果表を取得
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			// 結果表に格納されたレコードの内容を
			// BulletinBoardインスタンスに設定し、ArrayListインスタンスに追加
			while (rs.next()) {
				int id = rs.getInt("id");
				String loginId = rs.getString("login_id");
				String title = rs.getString("title");
				String postContent = rs.getString("post_content");
				String userName = rs.getString("name");
				String createDate = rs.getString("create_date");

				BulletinBoard list = new BulletinBoard(id, loginId,title, postContent,userName,createDate);

				BulletinBoardList.add(list);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {

			// データベースを切断する！
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return BulletinBoardList;
	}



	//掲示板に新規投稿する

public void Write(String title, String postContent ,String loginId) {

		Connection conn = null;

		try {

			// データベースへ接続する！
			conn = DBManager.getConnection();

			// INSERT文を準備する。

			String sql = "INSERT INTO bulletin_board (user_id,title,post_content,create_date) VALUES (?,?,?,now())";

			// INSERTを実行
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, loginId);
			pStmt.setString(2, title);
			pStmt.setString(3, postContent);

			pStmt.executeUpdate();

			pStmt.close();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();

				}
			}
		}

	}




//投稿を削除するメソッド
	public void Delete(String id) {
		Connection conn = null;

		try {

			// データベースへ接続する！
			conn = DBManager.getConnection();

			// DELETE文を準備する。

			String sql = "DELETE FROM bulletin_board WHERE id = ?";

			// DELETEを実行し、結果表を取得する！
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, id);

			pStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();

				}
			}
		}

	}







}

