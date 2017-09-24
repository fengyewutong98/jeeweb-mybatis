package cn.jeeweb.modules.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jeeweb.modules.dao.OrderDao;
import cn.jeeweb.modules.entity.Order;
import cn.jeeweb.modules.service.IOrder;

/**
 * 
 * @author lixiaofei
 * 2015年10月9日
 */
@Service("orderService")
public class OrderImpl implements IOrder{

	@Autowired
	private OrderDao orderDao;

	@Override
	public int addOrder(String tenantId, Order order) {
		// TODO Auto-generated method stub
		return orderDao.addOrder(order);
	}

	@Override
	public int delOrder(String tenantId, int[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delOrder(String tenantId, int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateOrder(String tenantId, Order order) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Order getOrder(String tenantId, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order getOrder(String tenantId, String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getOrderList(String tenantId, Map<String, Object> condition) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}