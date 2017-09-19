package cn.jeeweb.modules.entity;


import java.io.Serializable;

//
/**
 * 
 * @author lixiaofei
 * 2015年10月9日
 */
public class ProductCart implements Serializable{
	private static final long serialVersionUID = 5206105142300134374L;

	//主键
	private int id;
	//购物车id
	private int cartId;
	//商品Id
	private int productId;
	//商品数量
	private int amount;
	

	public ProductCart(){
	}
	


	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	
	public int getCartId() {
		return this.cartId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public int getProductId() {
		return this.productId;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public int getAmount() {
		return this.amount;
	}




	@Override
	public String toString() {
		return  "ProductCart ["
			+ "Id = " + getId() + ","
			+ "CartId = " + getCartId() + ","
			+ "ProductId = " + getProductId() + ","
			+ "Amount = " + getAmount() + ","
		+"]";
	}
	
}


