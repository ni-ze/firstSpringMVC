package com.imooc.mvcdemo.model;

 
import java.sql.Timestamp;

public class User{
	private Integer		id; 
	private String userName;
	private String password;
	private Timestamp  createTime; 
	private Timestamp loginDate;
	private Integer contiDays;
	private Integer point;  
 

	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(Timestamp loginDate) {
		this.loginDate = loginDate;
	}
	public Integer getContiDays() {
		return contiDays;
	}
	public void setContiDays(Integer contiDays) {
		this.contiDays = contiDays;
	}	
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	
}
