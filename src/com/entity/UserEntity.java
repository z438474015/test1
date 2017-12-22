package com.entity;

public class UserEntity {

	private String id;
	private String userName;
	private String password;
	private String nickName;
	private String audit="0";//0为无，1为有，默认为无
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public UserEntity(String userName, String password, String nickName, String audit) {
		super();
		this.userName = userName;
		this.password = password;
		this.nickName = nickName;
		this.audit = audit;
	}
	public UserEntity(String id, String userName, String password, String nickName, String audit) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.nickName = nickName;
		this.audit = audit;
	}
	public String getAudit() {
		return audit;
	}
	public void setAudit(String audit) {
		this.audit = audit;
	}
	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
