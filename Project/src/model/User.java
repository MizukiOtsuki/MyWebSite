package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User {


	private int id;
	private String loginId;
	private String name;
	private String password;
	private String createDate;
	private String updateDate;


	  // ログインセッションを保存するためのコンストラクタ
		public User(String loginId, String name) {
			this.loginId = loginId;
			this.name = name;
		}

		// 全てのデータをセットするコンストラクタ
		public User(int id, String loginId, String name, String password, String createDate,
				String updateDate) {
			this.id = id;
			this.loginId = loginId;
			this.name = name;
			this.password = password;
			this.createDate = createDate;
			this.updateDate = updateDate;
		}


		//getter,setterを用意
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getLoginId() {
			return loginId;
		}
		public void setLoginId(String loginId) {
			this.loginId = loginId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}

		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getCreateDate() {
			return createDate;
		}
		public void setCreateDate(String createDate) {
			this.createDate = createDate;
		}
		public String getUpdateDate() {
			return updateDate;
		}
		public void setUpdateDate(String updateDate) {
			this.updateDate = updateDate;
		}


		public String getFormatDate() {
			 SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	         Date date = null;
			try {
				date = sdFormat.parse(createDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH時mm分");
			return sdf.format(date);
		}


		public String getFormatDate2() {
			 SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	        Date date = null;
			try {
				date = sdFormat.parse(updateDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH時mm分");
			return sdf.format(date);
		}

}

