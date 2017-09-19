package cn.jeeweb.modules.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jeeweb.modules.dao.ProductCartDao;
import cn.jeeweb.modules.entity.ProductCart;
import cn.jeeweb.modules.service.IProductCart;


/**
 * 
 * @author lixiaofei
 * 2015年10月9日
 */
@Service("productCartService")
public class ProductCartImpl implements IProductCart{

	@Autowired
	private ProductCartDao productCartDao;

	@Override
	public int addProductCart(String tenantId, ProductCart productCart) {
		// TODO Auto-generated method stub
		return productCartDao.addProductCart(productCart);
	}

	@Override
	public int delProductCart(String tenantId, int[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delProductCart(String tenantId, int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateProductCart(String tenantId, ProductCart productCart) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ProductCart getProductCart(String tenantId, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductCart getProductCart(String tenantId, String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductCart> getProductCartList(String tenantId, Map<String, Object> condition) {
		// TODO Auto-generated method stub
		return null;
	}
	

	
	
	
}