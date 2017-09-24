package cn.jeeweb.modules.service;

import java.util.List;
import java.util.Map;

import cn.jeeweb.modules.entity.ProductDetail;

	
/**
 * 
 * @author lixiaofei
 * 2015年10月09日
 */
public interface IProductDetail{



	/**
	 * 根据条件查询所有列表
	 * @param tenantId 租户id
	 * @param condition
	 * @return
	 * @throws BusinessException
	 */
	List<ProductDetail> getProductDetailList(String tenantId,Map<String, Object> condition);
	/**
	 * 通富哦productId 查询商品
	 * @param productId
	 */
	ProductDetail getProductDetail(int productId);
	
	/**
	 * 根据Id 查询商品
	 * @param list
	 * @return
	 */
	List<ProductDetail>findByIdsMapToCart(List<Integer> list);

}