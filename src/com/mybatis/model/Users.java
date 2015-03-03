 package com.mybatis.model;
 /** 
* @ClassName: Users 
* @Description: 与数据库对应的pojo
* @author qiugui 
* @date 2015年3月3日 上午9:37:49 
*  
*/ 
public class Users {

	private int id;
	private String userName;
	private int userAge;
	private String userAddress;
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
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	
	
	
}

 