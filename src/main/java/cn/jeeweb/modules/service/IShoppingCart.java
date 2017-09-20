package cn.jeeweb.modules.service;


import cn.jeeweb.modules.entity.ShoppingCart;
import net.sf.json.JSONArray;


/**
 * 
 * @author lixiaofei
 * 2015年10月09日
 */
public interface IShoppingCart{
	/**
	 * 查询购物车
	 * @param userphone
	 * @return
	 */
	JSONArray querycart(String userphone);
	
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