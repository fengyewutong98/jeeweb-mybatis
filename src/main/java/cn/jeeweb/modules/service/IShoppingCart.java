package cn.jeeweb.modules.service;

import java.util.List;
import java.util.Map;

import cn.jeeweb.modules.entity.ShoppingCart;


/**
 * 
 * @author lixiaofei
 * 2015年10月09日
 */
public interface IShoppingCart{
	
	int addShoppingCart(String userphone,int sum,String productId);
	/**
	 * 根据code查询
	 * @param tenantId 租户id
	 * @param code
	 * @return
	 * @throws BusinessException
	 */
	ShoppingCart queryShoppingCart(String userphone);
	
	/**
	 * 根据code查询
	 * @param tenantId 租户id
	 * @param code
	 * @return
	 * @throws BusinessException
	 */
	ShoppingCart queryShoppingCart(int userId);

	
	/**
	 * 新增
	 * @param shoppingCart
	 * @param tenantId 租户id
	 * @return
	 * @throws BusinessException
	 */
	int addShoppingCart(String tenantId,ShoppingCart  shoppingCart);
	
	/**
	 * 根据ids删除
	 * @param tenantId 租户id
	 * @param ids
	 * @return
	 * @throws BusinessException
	 */
	int delShoppingCart(String tenantId,int[] ids);
	
	/**
	 * 根据id删除
	 * @param tenantId 租户id
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	int delShoppingCart(String tenantId,int id);
	
	/**
	 * 更新
	 * @param tenantId 租户id
	 * @param shoppingCart
	 * @return
	 * @throws BusinessException
	 */
	int updateShoppingCart(String tenantId,ShoppingCart  shoppingCart);

	/**
	 * 根据id查询
	 * @param tenantId 租户id
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	ShoppingCart getShoppingCart(String tenantId,int id);
	
	/**
	 * 根据code查询
	 * @param tenantId 租户id
	 * @param code
	 * @return
	 * @throws BusinessException
	 */
	ShoppingCart getShoppingCart(String tenantId,String code);
	
	
}