package cn.jeeweb.modules.entity;

import java.io.Serializable;
import java.sql.*;

//
/**
 * 
 * @author lixiaofei
 * 2015年10月9日
 */
public class ShoppingCart implements Serializable{
	private static final long serialVersionUID = -6869283700459171163L;

	//购物车主键
	private int cartId;
	//购物车状态0未购物中，1已购物
	private String cartStatus;
	//购物车总价
	private long orderPrice;
	//用户id
	private int userId;
	//购物车创建时间
	private Timestamp createDate;
	//
	private String userPhone;	

	public ShoppingCart(){
	}
	


	public String getUserPhone() {
		return userPhone;
	}



	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}



	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	
	public int getCartId() {
		return this.cartId;
	}

	public void setCartStatus(String cartStatus) {
		this.cartStatus = cartStatus;
	}
	
	public String getCartStatus() {
		return this.cartStatus;
	}

	public void setOrderPrice(long orderPrice) {
		this.orderPrice = orderPrice;
	}
	
	public long getOrderPrice() {
		return this.orderPrice;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getUserId() {
		return this.userId;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	
	public Timestamp getCreateDate() {
		return this.createDate;
	}
	
}


