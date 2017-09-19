package cn.jeeweb.modules.entity;


import java.io.Serializable;


/**
 * @author championyo
 *
 */
public class Category implements Serializable{
	private static final long serialVersionUID = 284913703797520146L;

	//商品父id
	private int categoryId;
	//商品子id
	private int secondCategoryId;
	//商品分类名称
	private String categoryName;
	//商品等级
	private int categoryLeve;
	//所属一级商品  
	private int belongFirstLeve;
	//样式添加
	private String claStyle;
	

	public Category(){
	}
	


	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	public int getCategoryId() {
		return this.categoryId;
	}

	public void setSecondCategoryId(int secondCategoryId) {
		this.secondCategoryId = secondCategoryId;
	}
	
	public int getSecondCategoryId() {
		return this.secondCategoryId;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryLeve(int categoryLeve) {
		this.categoryLeve = categoryLeve;
	}
	
	public int getCategoryLeve() {
		return this.categoryLeve;
	}

	public void setBelongFirstLeve(int belongFirstLeve) {
		this.belongFirstLeve = belongFirstLeve;
	}
	
	public int getBelongFirstLeve() {
		return this.belongFirstLeve;
	}

	public String getClaStyle() {
		return claStyle;
	}

	public void setClaStyle(String claStyle) {
		this.claStyle = claStyle;
	}

	
}


