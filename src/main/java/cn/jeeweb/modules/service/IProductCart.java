package cn.jeeweb.modules.service;

import java.util.List;
import java.util.Map;

import cn.jeeweb.modules.entity.ProductCart;


/**
 * 
 * @author lixiaofei
 * 2015年10月09日
 */
public interface IProductCart{

	
	/**
	 * 新增
	 * @param productCart
	 * @param tenantId 租户id
	 * @return
	 * @throws BusinessException
	 */
	int addProductCart(String tenantId,ProductCart  productCart);
	
	/**
	 * 更新
	 * @param tenantId 租户id
	 * @param productCart
	 * @return
	 * @throws BusinessException
	 */
	int updateProductCart(String tenantId,ProductCart  productCart);

	/**
	 * 根据id查询
	 * @param tenantId 租户id
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	ProductCart getProductCart(String tenantId,int id);
	
	/**
	 * 根据code查询
	 * @param tenantId 租户id
	 * @param code
	 * @return
	 * @throws BusinessException
	 */
	ProductCart getProductCart(String tenantId,String code);
	
	/**
	 * 根据条件查询所有列表
	 * @param tenantId 租户id
	 * @param condition
	 * @return
	 * @throws BusinessException
	 */
	List<ProductCart> getProductCartList(String tenantId,Map<String, Object> condition);

	/**
	 * 删除carId 里的productId
	 * @param carId
	 * @param productId
	 * @return
	 */
	int delProductCart(String carId, String productId);
	
}