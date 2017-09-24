package cn.jeeweb.modules.dao;


import java.util.*;

import org.apache.ibatis.annotations.Param;

import cn.jeeweb.modules.entity.Order;


/**
 * 
 * @author lixiaofei
 * 2015年7月14日
 */
public interface OrderDao {

	/**
	 * 新增
	 * @param order
	 * @return
	 */
	int addOrder(Order  order);
	
	/**
	 * 根据id删除
	 * @param tenantId 租户id
	 * @param id
	 * @return
	 */
	int delOrder(@Param("tenantId")String tenantId,@Param("id")int id);
	
	/**
	 * 根据id更新
	 * @param order 
	 * @return
	 */
	int updateOrder(Order  order);
	
	/**
	 * 根据id查询
	 * @param tenantId 租户id
	 * @param id
	 * @return
	 */
	Order getOrderById(@Param("tenantId")String tenantId,@Param("id")int id);

	/**
	 * 根据code查询
	 * @param tenantId 租户id
	 * @param code
	 * @return
	 */
	Order getOrderByCode(@Param("tenantId")String tenantId,@Param("code")String code);
	
	/**
	 * 根据条件查询所有列表
	 * @param condition
	 * @return
	 */
	List<Order> getOrderList(Map<String,Object> condition);
	
}