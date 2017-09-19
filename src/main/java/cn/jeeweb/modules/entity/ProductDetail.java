package cn.jeeweb.modules.entity;

import java.io.Serializable;

//
/**
 * 
 * @author lixiaofei
 * 2015年10月9日
 */
public class ProductDetail implements Serializable{
	private static final long serialVersionUID = -6959774185731368106L;

	//商品id
	private int productId;
	//商品所属二级分类
	private int productBelogTwoCategoryId;
	//商品库存
	private int productNum;
	//商品名称
	private String productName;
	//商品描述
	private String productDescribe;
	//商品单价
	private float productPrice;
	//商品图片
	private String imgurl;
	//产地
	private String originAddress;
	//保质期
	private String period;
	//净重/尺寸比例
	private String scale;
	//口味
	private String taste;
	//商品所属三级分类
	private int productBelogThreeCategoryId;
	

	public ProductDetail(){
	}
	


	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public int getProductId() {
		return this.productId;
	}

	public void setProductBelogTwoCategoryId(int productBelogTwoCategoryId) {
		this.productBelogTwoCategoryId = productBelogTwoCategoryId;
	}
	
	public int getProductBelogTwoCategoryId() {
		return this.productBelogTwoCategoryId;
	}

	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}
	
	public int getProductNum() {
		return this.productNum;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getProductName() {
		return this.productName;
	}

	public void setProductDescribe(String productDescribe) {
		this.productDescribe = productDescribe;
	}
	
	public String getProductDescribe() {
		return this.productDescribe;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}
	
	public float getProductPrice() {
		return this.productPrice;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	
	public String getImgurl() {
		return this.imgurl;
	}

	public void setOriginAddress(String originAddress) {
		this.originAddress = originAddress;
	}
	
	public String getOriginAddress() {
		return this.originAddress;
	}

	public void setPeriod(String period) {
		this.period = period;
	}
	
	public String getPeriod() {
		return this.period;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}
	
	public String getScale() {
		return this.scale;
	}

	public void setTaste(String taste) {
		this.taste = taste;
	}
	
	public String getTaste() {
		return this.taste;
	}

	public void setProductBelogThreeCategoryId(int productBelogThreeCategoryId) {
		this.productBelogThreeCategoryId = productBelogThreeCategoryId;
	}
	
	public int getProductBelogThreeCategoryId() {
		return this.productBelogThreeCategoryId;
	}
	
}


