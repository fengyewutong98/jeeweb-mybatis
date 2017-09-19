package cn.jeeweb.modules.entity;


import java.io.Serializable;

//
/**
 * 
 * @author lixiaofei
 * 2015年10月9日
 */
public class Address implements Serializable{
	private static final long serialVersionUID = 3251473957682190666L;

	//主键地址
	private int addressId;
	//用户
	private int userId;
	//详细地址
	private String addressDetail;
	//收件人
	private String recipients;
	//收件人电话
	private String telephone;
	

	public Address(){
	}
	


	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	
	public int getAddressId() {
		return this.addressId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getUserId() {
		return this.userId;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}
	
	public String getAddressDetail() {
		return this.addressDetail;
	}

	public void setRecipients(String recipients) {
		this.recipients = recipients;
	}
	
	public String getRecipients() {
		return this.recipients;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public String getTelephone() {
		return this.telephone;
	}




	@Override
	public String toString() {
		return  "Address ["
			+ "AddressId = " + getAddressId() + ","
			+ "UserId = " + getUserId() + ","
			+ "AddressDetail = " + getAddressDetail() + ","
			+ "Recipients = " + getRecipients() + ","
			+ "Telephone = " + getTelephone() + ","
		+"]";
	}
	
}


