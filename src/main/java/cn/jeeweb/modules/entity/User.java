package cn.jeeweb.modules.entity;


import java.io.Serializable;
import java.sql.*;

//
/**
 * 
 * @author lixiaofei
 * 2015年10月9日
 */
public class User implements Serializable{
	private static final long serialVersionUID = 828818795166409593L;

	//用户Id
	private int userId;
	//电话
	private String mobile;
	//密码
	private String password;
	//用户名
	private String userName;
	//头像地址
	private String img;
	

	public User(){
	}
	


	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getUserId() {
		return this.userId;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getMobile() {
		return this.mobile;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return this.password;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserName() {
		return this.userName;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
	public String getImg() {
		return this.img;
	}




	@Override
	public String toString() {
		return  "User ["
			+ "UserId = " + getUserId() + ","
			+ "Mobile = " + getMobile() + ","
			+ "Password = " + getPassword() + ","
			+ "UserName = " + getUserName() + ","
			+ "Img = " + getImg() + ","
		+"]";
	}
	
}


