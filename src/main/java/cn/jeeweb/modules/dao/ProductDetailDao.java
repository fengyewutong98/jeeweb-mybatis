package cn.jeeweb.modules.dao;


import java.util.*;


import cn.jeeweb.modules.entity.ProductDetail;


/**
 * 
 * @author lixiaofei
 * 2015年7月14日
 */
public interface ProductDetailDao {

	List<ProductDetail> getProductDetailList(Map<String,Object> condition);
	
	ProductDetail getProductId(int productId);
	
	List<ProductDetail> findByIdsMapToCart(List<Integer> list);
	
}