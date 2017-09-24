package cn.jeeweb.modules.service.impl;

import java.util.ArrayList;
import java.util.List;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.jeeweb.modules.dao.ProductCartDao;
import cn.jeeweb.modules.dao.ProductDetailDao;
import cn.jeeweb.modules.dao.ShoppingCartDao;
import cn.jeeweb.modules.entity.ProductCart;
import cn.jeeweb.modules.entity.ProductDetail;
import cn.jeeweb.modules.entity.ShoppingCart;
import cn.jeeweb.modules.service.IShoppingCart;
import net.sf.json.JSONArray;
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
	@Autowired
	private ProductDetailDao productDetailDao;
	
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
			log.info("插入返回的主键==============="+i);
			ShoppingCart shoppingCart2 = shoppingCartDao.queryShopp(userphone);
			i= shoppingCart2.getCartId();
			log.info("查询返回主键--------------------"+i);
		}else {
			
			i= shoppingCart.getCartId();	
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
		ShoppingCart shoppingCart = shoppingCartDao.queryShopp(userphone);
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonarry = new JSONArray();
		jsonObject.put("shoppingCart", shoppingCart);
		if(shoppingCart==null) {
			log.info("购物车无订单");
			return jsonObject;
		}
		log.info("查询购物车");
		ProductCart productCart  = new ProductCart();
		productCart.setCartId(shoppingCart.getCartId());
		productCart.setUserPhone(userphone);
		List<ProductCart> list = productCartDao.queryShoppingCart(productCart);
		List<Integer> list1 = new ArrayList<>();
		for (ProductCart productCart2 : list) {
			list1.add(productCart2.getProductId());
		}
		List<ProductDetail> list3 = productDetailDao.findByIdsMapToCart(list1);
		for (int i = 0;i<list3.size();i++) {
			JSONObject jsonobject = JSONObject.fromObject(list3.get(i));
			jsonobject.put("num", list.get(i).getAmount());
			jsonarry.add(jsonobject);
		}
		jsonObject.put("jsonarry", jsonarry);
		return jsonObject;
	}
	
}