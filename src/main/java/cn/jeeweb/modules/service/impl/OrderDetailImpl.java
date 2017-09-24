package cn.jeeweb.modules.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.jeeweb.modules.dao.OrderDetailDao;
import cn.jeeweb.modules.dao.ProductCartDao;
import cn.jeeweb.modules.dao.ShoppingCartDao;
import cn.jeeweb.modules.entity.OrderDetail;
import cn.jeeweb.modules.entity.ProductCart;
import cn.jeeweb.modules.entity.ShoppingCart;
import cn.jeeweb.modules.order.entity.Orders;
import cn.jeeweb.modules.service.IOrderDetail;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


/**
 * 
 * @author lixiaofei
 * 2015年10月9日
 */
@Service("orderDetailService")
public class OrderDetailImpl implements IOrderDetail{

	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private OrderDetailDao orderDetailDao;
	@Autowired
	private ShoppingCartDao shoppingCartDao;
	@Autowired
	private ProductCartDao productCartDao;

	@Override
	public int addOrderDetail(String tenantId, OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		return orderDetailDao.addOrderDetail(orderDetail);
	}

	@Override
	public int delOrderDetail(String tenantId, int[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delOrderDetail(String tenantId, int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateOrderDetail(String tenantId, OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public OrderDetail getOrderDetail(String tenantId, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDetail getOrderDetail(String tenantId, String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDetail> getOrderDetailList(String tenantId, Map<String, Object> condition) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	@Transactional
	public int addOrderDetailAndCreateCart(OrderDetail orderDetail,String ordernoproduct,String userphone) {
		// TODO Auto-generated method stub
		//增加订单修改购物车状态
		//创建新的购物车
		log.info("创建订单");
		orderDetailDao.addOrderDetail(orderDetail);
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.setCartId(orderDetail.getCarId());
		shoppingCart.setCartStatus("1");
		shoppingCartDao.updateShoppingCart(shoppingCart); //更新订单状态 1 已下单购物车商品
		ShoppingCart shoppingCart1 = new ShoppingCart();
		shoppingCart1.setUserPhone(userphone);
		shoppingCart1.setCartStatus("0");
		JSONArray jsonArray = JSONArray.fromObject(ordernoproduct);
		if(jsonArray.size()>0) {
			int j =shoppingCartDao.addShoppingCart(shoppingCart1);
			log.info("插入返回的主键==============="+j);
			ShoppingCart shoppingCart2 = shoppingCartDao.queryShopp(userphone);
			j= shoppingCart2.getCartId();
			log.info("查询返回主键--------------------"+j);
			
			List<ProductCart> listcart = new ArrayList<>();
			for(int i =0;i<jsonArray.size();i++) {
				JSONObject jsonObject =  (JSONObject) jsonArray.get(i);
				Integer productid  = (Integer) jsonObject.get("productid");
				Integer num = (Integer) jsonObject.get("num");
				ProductCart productCart = new ProductCart();
				productCart.setProductId(productid);
				productCart.setCartId(j);
				productCart.setAmount(num);
				productCart.setUserPhone(userphone);
				listcart.add(productCart);
				productCartDao.addProductCart(productCart);  //增加产品相关信息
			}
//			productCartDao.insertCodeBatch(listcart);  //以后修改批处理
			
		}
		log.info("商品加入购物车成功");
		return 0;
	}

	@Override
	public List<OrderDetail> queryOrder(int userId) {
		// TODO Auto-generated method stub
		return orderDetailDao.queryOrder(userId);
	}
	
	
	
}