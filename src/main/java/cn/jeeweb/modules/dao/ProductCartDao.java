package cn.jeeweb.modules.dao;



import java.util.List;
import java.util.Map;


import cn.jeeweb.modules.entity.ProductCart;


/**
 * 
 * @author lixiaofei
 * 2015年7月14日
 */
public interface ProductCartDao {

	/**
	 * 查询购物车
	 * @param userphone
	 * @return
	 */
	ProductCart querycart(String userphone);
	/**
	 * 新增
	 * @param productCart
	 * @return
	 */
	int addProductCart(ProductCart  productCart);
	
	/**
	 * 根据id更新
	 * @param productCart 
	 * @return
	 */
	int updateProductCart(ProductCart  productCart);
	
	/**
	 * 根据条件查询所有列表
	 * @param condition
	 * @return
	 */
	List<ProductCart> getProductCartList(Map<String,Object> condition);
	
}