package cn.jeeweb.modules.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	

	@Override
	@Transactional
	public int delProductCart(String carId,String productId) {
		// TODO Auto-generated method stub
		Map <String,Object> map = new HashMap<>();
		ProductCart productCart = new ProductCart();
		productCart.setCartId(Integer.valueOf(carId));
		productCart.setProductId(Integer.valueOf(productId));
		return productCartDao.delProductCart(productCart);
	}
	
	
}