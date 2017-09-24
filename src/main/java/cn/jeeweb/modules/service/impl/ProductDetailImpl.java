package cn.jeeweb.modules.service.impl;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jeeweb.modules.dao.ProductDetailDao;
import cn.jeeweb.modules.service.IProductDetail;
import cn.jeeweb.modules.entity.ProductDetail;

/**
 * 
 * @author lixiaofei
 * 2015年10月9日
 */
@Service("productDetailService")
public class ProductDetailImpl implements IProductDetail{

	@Autowired
	private ProductDetailDao productDetailDao;

	@Override
	public List<ProductDetail> getProductDetailList(String tenantId,
			Map<String, Object> condition) {
		// TODO Auto-generated method stub
		return productDetailDao.getProductDetailList(condition);
	}

	@Override
	public ProductDetail getProductDetail(int productId) {
		// TODO Auto-generated method stub
		return productDetailDao.getProductId(productId);
	}

	@Override
	public List<ProductDetail> findByIdsMapToCart(List<Integer> list) {
		// TODO Auto-generated method stub
		return productDetailDao.findByIdsMapToCart(list);
	}
	
	
}