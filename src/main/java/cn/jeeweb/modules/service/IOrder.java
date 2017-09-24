package cn.jeeweb.modules.service;

import java.util.List;
import java.util.Map;

import cn.jeeweb.modules.entity.Order;

/**
 * 
 * @author lixiaofei
 * 2015年10月09日
 */
public interface IOrder{

	
	/**
	 * 新增
	 * @param order
	 * @param tenantId 租户id
	 * @return
	 * @throws BusinessException
	 */
	int addOrder(String tenantId,Order  order);
	
	/**
	 * 根据ids删除
	 * @param tenantId 租户id
	 * @param ids
	 * @return
	 * @throws BusinessException
	 */
	int delOrder(String tenantId,int[] ids);
	
	/**
	 * 根据id删除
	 * @param tenantId 租户id
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	int delOrder(String tenantId,int id);
	
	/**
	 * 更新
	 * @param tenantId 租户id
	 * @param order
	 * @return
	 * @throws BusinessException
	 */
	int updateOrder(String tenantId,Order  order);

	/**
	 * 根据id查询
	 * @param tenantId 租户id
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	Order getOrder(String tenantId,int id);
	
	/**
	 * 根据code查询
	 * @param tenantId 租户id
	 * @param code
	 * @return
	 * @throws BusinessException
	 */
	Order getOrder(String tenantId,String code);
	
	/**
	 * 根据条件查询所有列表
	 * @param tenantId 租户id
	 * @param condition
	 * @return
	 * @throws BusinessException
	 */
	List<Order> getOrderList(String tenantId,Map<String, Object> condition);
	
}