package cn.jeeweb.modules.common.util;

public enum OrderEnum {

	ORDER_TYPE1("01", "待发货"),
	ORDER_TYPE2("02", "已发货"),
	ORDER_TYPE3("03", "已签收"),
	ORDER_TYPE4("04", "已完毕");
	// 成员变量
	private String index;
	private String name;

	// 构造方法
	private OrderEnum( String index,String name) {
		this.name = name;
		this.index = index;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	// 普通方法 获取index
	public static String getIndex(String index) {
		for (OrderEnum c : OrderEnum.values()) {
			if (c.getIndex().equals(index)) {
				return c.index;
			}
		}
		return null;
	}
	// 普通方法 获取名称
	public static String getName(String index) {
		for (OrderEnum c : OrderEnum.values()) {
			if (c.getIndex().equals(index)) {
				return c.name;
			}
		}
		return null;
	}
	
}
