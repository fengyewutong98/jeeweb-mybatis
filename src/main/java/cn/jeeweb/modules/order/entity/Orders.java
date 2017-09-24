package cn.jeeweb.modules.order.entity;

/**
 * 订单生成请求的参数 
 * @author championyo
 *
 */
public class Orders {
	
	private Integer productid;
	
	private Integer num;

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	

}
