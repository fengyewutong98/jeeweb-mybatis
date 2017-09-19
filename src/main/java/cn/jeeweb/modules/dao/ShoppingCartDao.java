package cn.jeeweb.modules.dao;


import java.util.*;

import org.apache.ibatis.annotations.Param;

import cn.jeeweb.modules.entity.ShoppingCart;

/**
 * 
 * @author lixiaofei
 * 2015年7月14日
 */
public interface ShoppingCartDao {
	
	
	/**
	 * 根据用户id 查询
	 * @param userId
	 * @return
	 */
	ShoppingCart queryShoppingCart(int userId);
	/**
	 * 根据用户id 查询
	 * @param userphone
	 * @return
	 */
	ShoppingCart queryShopp(String userPhone);
	/**
	 * 新增
	 * @param shoppingCart
	 * @return
	 */
	int addShoppingCart(ShoppingCart  shoppingCart);
	
	/**
	 * 根据id删除
	 * @param tenantId 租户id
	 * @param id
	 * @return
	 */
	int delShoppingCart(@Param("tenantId")String tenantId,@Param("id")int id);
	
	/**
	 * 根据id更新
	 * @param shoppingCart 
	 * @return
	 */
	int updateShoppingCart(ShoppingCart  shoppingCart);
	/**
	 * 根据条件查询所有列表
	 * @param condition
	 * @return
	 */
	List<ShoppingCart> getShoppingCartList(Map<String,Object> condition);
	
}