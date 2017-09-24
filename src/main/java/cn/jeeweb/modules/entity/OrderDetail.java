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
public class OrderDetail implements Serializable{
	private static final long serialVersionUID = -8898346445323124356L;

	//订单Id
	private int id;
	//用户Id
	private int userId;
	//订单状态
	private String orderStatus;
	//订单状态名称
	private String orderStatement;
	//购物车预订单id
	private int carId;
	//创建时间
	private Timestamp createDate;
	//订单数据[{productid:'12',num:'2'},{productid:'12',num:'2'}]
	private String orderJson;
	//订单接收人
	private String orderOwner;
	//订单电话
	private String orderTelephone;
	//订单地址
	private String addressDetail;
	//订单总额
	private BigDecimal orderPayAmount;
	//orderUuid
	private String orderUuid;

	public OrderDetail(){
	}
	


	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getUserId() {
		return this.userId;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	public String getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatement(String orderStatement) {
		this.orderStatement = orderStatement;
	}
	
	public String getOrderStatement() {
		return this.orderStatement;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}
	
	public int getCarId() {
		return this.carId;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	
	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setOrderJson(String orderJson) {
		this.orderJson = orderJson;
	}
	
	public String getOrderJson() {
		return this.orderJson;
	}

	public void setOrderOwner(String orderOwner) {
		this.orderOwner = orderOwner;
	}
	
	public String getOrderOwner() {
		return this.orderOwner;
	}

	public void setOrderTelephone(String orderTelephone) {
		this.orderTelephone = orderTelephone;
	}
	
	public String getOrderTelephone() {
		return this.orderTelephone;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}
	
	public String getAddressDetail() {
		return this.addressDetail;
	}

	public void setOrderPayAmount(BigDecimal orderPayAmount) {
		this.orderPayAmount = orderPayAmount;
	}
	
	public BigDecimal getOrderPayAmount() {
		return this.orderPayAmount;
	}



	public String getOrderUuid() {
		return orderUuid;
	}



	public void setOrderUuid(String orderUuid) {
		this.orderUuid = orderUuid;
	}

	
}


