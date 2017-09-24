package cn.jeeweb.modules.dao;


import java.util.*;

import org.apache.ibatis.annotations.Param;

import cn.jeeweb.modules.entity.OrderDetail;


/**
 * 
 * @author lixiaofei
 * 2015年7月14日
 */
public interface OrderDetailDao {

	
	/**
	 * 根据用户userId 查询
	 * @param userId
	 * @return
	 */
	List<OrderDetail> queryOrder(Integer userId);
	/**
	 * 新增
	 * @param orderDetail
	 * @return
	 */
	int addOrderDetail(OrderDetail  orderDetail);
	
	/**
	 * 根据id删除
	 * @param tenantId 租户id
	 * @param id
	 * @return
	 */
	int delOrderDetail(@Param("tenantId")String tenantId,@Param("id")int id);
	
	/**
	 * 根据id更新
	 * @param orderDetail 
	 * @return
	 */
	int updateOrderDetail(OrderDetail  orderDetail);
	
	/**
	 * 根据id查询
	 * @param tenantId 租户id
	 * @param id
	 * @return
	 */
	OrderDetail getOrderDetailById(@Param("tenantId")String tenantId,@Param("id")int id);

	/**
	 * 根据code查询
	 * @param tenantId 租户id
	 * @param code
	 * @return
	 */
	OrderDetail getOrderDetailByCode(@Param("tenantId")String tenantId,@Param("code")String code);
	
	/**
	 * 根据条件查询所有列表
	 * @param condition
	 * @return
	 */
	List<OrderDetail> getOrderDetailList(Map<String,Object> condition);
	
	
}