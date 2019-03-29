package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BulletinBoard {


	private int id;
	private String loginId;
	private String title;
	private String postContent;
	private String createDate;

	private String userName;


	public BulletinBoard(int id, String loginId,String title, String postContent,String userName, String createDate) {
		this.id = id;
		this.loginId = loginId;
		this.title = title;
		this.postContent = postContent;
		this.createDate = createDate;
		this.userName = userName;

	}


	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
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




}
