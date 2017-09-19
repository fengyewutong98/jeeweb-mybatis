package cn.jeeweb.modules.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.jeeweb.modules.dao.ProductCartDao;
import cn.jeeweb.modules.dao.ShoppingCartDao;
import cn.jeeweb.modules.entity.ProductCart;
import cn.jeeweb.modules.entity.ShoppingCart;
import cn.jeeweb.modules.service.IShoppingCart;
import net.sf.json.JSONObject;


/**
 * 
 * @author lixiaofei
 * 2015年10月9日
 */
@Service("shoppingCartService")
public class ShoppingCartImpl implements IShoppingCart{
	
	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private ShoppingCartDao shoppingCartDao;

	@Autowired
	private ProductCartDao productCartDao; 
	@Override
	public int addShoppingCart(String tenantId, ShoppingCart shoppingCart) {
		// TODO Auto-generated method stub说
		return shoppingCartDao.addShoppingCart(shoppingCart);
	}

	@Override
	public int delShoppingCart(String tenantId, int[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delShoppingCart(String tenantId, int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateShoppingCart(String tenantId, ShoppingCart shoppingCart) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ShoppingCart getShoppingCart(String tenantId, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShoppingCart getShoppingCart(String tenantId, String code) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ShoppingCart queryShoppingCart(int userId) {
		// TODO Auto-generated method stub
		log.info("service查询购物车"+userId);
		return shoppingCartDao.queryShoppingCart(userId);
	}

	/**
	 * 商品增加
	 */
	@Override
	@Transactional
	public int addShoppingCart(String userphone, int mun, String productId) {
		// TODO Auto-generated method stub
		log.info("通过查询用户userphone");
		ShoppingCart shoppingCart = shoppingCartDao.queryShopp(userphone);
		log.info("查询购物车"+shoppingCart);
		int i=0;
		if(shoppingCart==null) {
			ShoppingCart shoppingCart1 = new ShoppingCart();
			shoppingCart1.setUserPhone(userphone);
			shoppingCart1.setCartStatus("0");
			i =shoppingCartDao.addShoppingCart(shoppingCart1);
		}
		ProductCart productCart = new ProductCart();
		productCart.setProductId(Integer.valueOf(productId));
		productCart.setCartId(i);
		productCart.setAmount(mun);
		productCart.setUserPhone(userphone);
		productCartDao.addProductCart(productCart);
		log.info("商品加入购物车成功");
		return i;
	}

	@Override
	public ShoppingCart queryShoppingCart(String userphone) {
		// TODO Auto-generated method stub
		
		log.info("1111111111111");
		return  shoppingCartDao.queryShopp(userphone);
	}

	@Override
	public JSONObject querycart(String userphone) {
		// TODO Auto-generated method stub
		log.info("调用购物车关联表");
		ProductCart productCart = productCartDao.querycart(userphone);
		log.info("查询购物车");
		
		return null;
	}
	
}