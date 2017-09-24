package cn.jeeweb.modules.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.*;

//
/**
 * 
 * @author lixiaofei
 * 2015年10月9日
 */
public class Order implements Serializable{
	private static final long serialVersionUID = -2631244093654627623L;

	//订单Id
	private int orderId;
	//用户Id
	private int userId;
	//订单状态
	private String orderStatus;
	//订单总额
	private BigDecimal orderPayAmount;
	//购物车预订单id
	private int carId;
	//创建时间
	private Timestamp createDate;
	//订单地址
	private String addressDetail;
	//订单状态名称
	private String orderStatement;
	//订单数据[{productid:'12',num:'2'},{productid:'12',num:'2'}]
	private String orderJson;
	//订单接收人
	private String orderOwner;
	//订单电话
	private String orderTelephone;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public BigDecimal getOrderPayAmount() {
		return orderPayAmount;
	}
	public void setOrderPayAmount(BigDecimal orderPayAmount) {
		this.orderPayAmount = orderPayAmount;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public String getAddressDetail() {
		return addressDetail;
	}
	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}
	public String getOrderStatement() {
		return orderStatement;
	}
	public void setOrderStatement(String orderStatement) {
		this.orderStatement = orderStatement;
	}
	public String getOrderJson() {
		return orderJson;
	}
	public void setOrderJson(String orderJson) {
		this.orderJson = orderJson;
	}
	public String getOrderOwner() {
		return orderOwner;
	}
	public void setOrderOwner(String orderOwner) {
		this.orderOwner = orderOwner;
	}
	public String getOrderTelephone() {
		return orderTelephone;
	}
	public void setOrderTelephone(String orderTelephone) {
		this.orderTelephone = orderTelephone;
	}

}


