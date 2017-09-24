package cn.jeeweb.modules.order.entity;

import java.sql.Timestamp;
import java.util.List;

public class OrderReq {
	//订单状态
	private String orderStatus;
	//购物车预订单id
	private int carId;
	//创建时间
	private Timestamp createDate;
	//订单地址
	private String addressDetail;
	//订单数据[{productid:'12',num:'2'},{productid:'12',num:'2'}]
	private List<Orders> orderJson;
	//订单接收人
	private String orderOwner;
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
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
	public List<Orders> getOrderJson() {
		return orderJson;
	}
	public void setOrderJson(List<Orders> orderJson) {
		this.orderJson = orderJson;
	}
	public String getOrderOwner() {
		return orderOwner;
	}
	public void setOrderOwner(String orderOwner) {
		this.orderOwner = orderOwner;
	}

	
}
