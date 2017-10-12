package cn.jeeweb.modules.service;

import java.util.List;
import java.util.Map;

import cn.jeeweb.modules.entity.OrderDetail;
import net.sf.json.JSONObject;


/**
 * 
 * @author lixiaofei
 * 2015年10月09日
 */
public interface IOrderDetail{

	
	/**
	 * 根据UserId查询
	 * @param tenantId 租户id
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	List<OrderDetail> queryOrder(OrderDetail order);
	/**
	 * 创建订单
	 * @param orderDetail
	 * @param ordernoproduct
	 * @return
	 */
	 int addOrderDetailAndCreateCart(OrderDetail orderDetail,String ordernoproduct,String userphone);
	/**
	 * 新增
	 * @param orderDetail
	 * @param tenantId 租户id
	 * @return
	 * @throws BusinessException
	 */
	int addOrderDetail(String tenantId,OrderDetail  orderDetail);
	
	/**
	 * 根据ids删除
	 * @param tenantId 租户id
	 * @param ids
	 * @return
	 * @throws BusinessException
	 */
	int delOrderDetail(String tenantId,int[] ids);
	
	/**
	 * 根据id删除
	 * @param tenantId 租户id
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	int delOrderDetail(String tenantId,int id);
	
	/**
	 * 更新
	 * @param tenantId 租户id
	 * @param orderDetail
	 * @return
	 * @throws BusinessException
	 */
	int updateOrderDetail(String tenantId,OrderDetail  orderDetail);

	/**
	 * 根据id查询
	 * @param tenantId 租户id
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	OrderDetail getOrderDetail(String tenantId,int id);
	
	/**
	 * 根据code查询
	 * @param tenantId 租户id
	 * @param code
	 * @return
	 * @throws BusinessException
	 */
	OrderDetail getOrderDetail(String tenantId,String code);
	
	/**
	 * 根据条件查询所有列表
	 * @param tenantId 租户id
	 * @param condition
	 * @return
	 * @throws BusinessException
	 */
	List<OrderDetail> getOrderDetailList(String tenantId,Map<String, Object> condition);
	/**
	 * 根据订单id查询订单详情
	 * @param id
	 * @return
	 */
	JSONObject querOrderById(String id);
	
}