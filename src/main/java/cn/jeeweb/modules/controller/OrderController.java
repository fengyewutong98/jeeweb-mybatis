package cn.jeeweb.modules.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonObject;

import cn.jeeweb.modules.common.util.MsgUtil;
import cn.jeeweb.modules.common.util.OrderEnum;
import cn.jeeweb.modules.entity.OrderDetail;
import cn.jeeweb.modules.entity.ProductDetail;
import cn.jeeweb.modules.order.entity.Orders;
import cn.jeeweb.modules.service.IMsgService;
import cn.jeeweb.modules.service.IOrderDetail;
import cn.jeeweb.modules.service.IProductDetail;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


/**
 * order订单插入，查询修改状态
 * @author championyo
 *
 */
@Controller
@RequestMapping(value="/order")
public class OrderController {
	
	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private IProductDetail iProductDetail;
	@Autowired
	private IOrderDetail  iOrderDetail;
	
	/**
	 * 保存订单
	 * @param request
	 * @param response
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value="/saveorder" ,method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE +";charset=UTF-8")
	@ResponseBody
	public void saveorder(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		
		
		String  userphone = (String) request.getSession().getAttribute("phone");
		Integer userId = (Integer) request.getSession().getAttribute("userId");
		
		String orderStatus = request.getParameter("orderStatus"); 
		String carId = request.getParameter("carId"); 
		String addressDetail = request.getParameter("addressDetail"); 
		String orderOwner = request.getParameter("orderOwner"); 
		String orderTelephone = request.getParameter("orderTelephone"); 
		String orderJson = request.getParameter("orderJson"); 
		String ordernoproduct = request.getParameter("ordernoproduct"); 
		addressDetail = URLDecoder.decode(addressDetail, "utf-8");
		orderOwner = URLDecoder.decode(orderOwner, "utf-8");
		String orderStatement = OrderEnum.getName(orderStatus);
		OrderDetail order = new OrderDetail();
		String uuid = UUID.randomUUID().toString();
		String orderUuid = "FKCS"+uuid.replace("-", "").substring(0, 10);
		order.setOrderUuid(orderUuid);
		order.setOrderStatus(orderStatus);
		order.setUserId(userId);
		order.setOrderStatement(orderStatement);
		order.setCarId(Integer.valueOf(carId));
		order.setAddressDetail(addressDetail);
		order.setOrderOwner(orderOwner);
		order.setOrderTelephone(orderTelephone);
		order.setOrderJson(orderJson);
		JSONArray jsonArray = JSONArray.fromObject(orderJson);
		List<Orders> listorder = new ArrayList<>();
		List<Integer> list = new ArrayList<>(); 
		for(int i =0;i<jsonArray.size();i++) {
			JSONObject jsonObject =  (JSONObject) jsonArray.get(i);
			Integer productid  = (Integer) jsonObject.get("productid");
			Integer num = (Integer) jsonObject.get("num");
			Orders orders = new Orders();
			orders.setNum(num);
			orders.setProductid(productid);
			listorder.add(orders);
			list.add(productid);
		}
		BigDecimal payamout = new BigDecimal(0);
		List <ProductDetail> listProductDetail = iProductDetail.findByIdsMapToCart(list);
		for(int i =0;i<listProductDetail.size();i++) {
			for(int j=0;j<listorder.size();j++) {
				if(listorder.get(j).getProductid()==listProductDetail.get(i).getProductId()) {
					BigDecimal productamout =new BigDecimal(listProductDetail.get(i).getProductPrice()).multiply(new BigDecimal(listorder.get(j).getNum()));
					payamout = payamout.add(productamout).setScale(2,BigDecimal.ROUND_HALF_UP);;
				}
			}
		}
		order.setOrderPayAmount(payamout);
		
		String callback = request.getParameter("callback"); 
		JSONObject json = new JSONObject();
		response.setContentType("text/javascript");
		try {
			iOrderDetail.addOrderDetailAndCreateCart(order, ordernoproduct,userphone);
//			iOrder.addOrder("", order);
			json.put("returnCode", "000000");
	        json.put("returnMsg", "成功");
		}catch(Exception e){
			json.put("returnCode", "111111");
	        json.put("returnMsg", "服务器异常");
			log.info("错误异常"+e);
		}
		log.info("--查询成功--");
		/*try {
			int i = MsgUtil.send(orderUuid);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			log.info("邮件发送失败song");
		}*/
		try {
		    PrintWriter out = response.getWriter();
			out.write(callback+'('+json+')'); 
	        out.flush(); 
	        log.info("--回调数据成功成功--");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	/**
	 * 查询订单 
	 * @param request
	 * @param response
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value="/queryOrder")
	@ResponseBody
	public void queryOrder(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		
		
		Integer userId =  (Integer) request.getSession().getAttribute("userId");
		String orderStatus = request.getParameter("orderStatus");
		OrderDetail order = new OrderDetail();
		if(StringUtils.isNotBlank(orderStatus)) {
			order.setOrderStatus(orderStatus);	
		}
		order.setUserId(userId);
		
		
		String callback = request.getParameter("callback"); 
		JSONObject json = new JSONObject();
		response.setContentType("text/javascript");
		try {
			List <OrderDetail> list =iOrderDetail.queryOrder(order);
//			iOrder.addOrder("", order);
			json.put("list", list);
			json.put("returnCode", "000000");
	        json.put("returnMsg", "成功");
		}catch(Exception e){
			json.put("returnCode", "111111");
	        json.put("returnMsg", "服务器异常");
			log.info("错误异常"+e);
		}
		log.info("--查询成功--");
		
		try {
		    PrintWriter out = response.getWriter();
			out.write(callback+'('+json+')'); 
	        out.flush(); 
	        log.info("--回调数据成功成功--");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}

	
	/**
	 * 查询订单 
	 * @param request
	 * @param response
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value="/queryOrderById")
	@ResponseBody
	public void queryOrderById(HttpServletRequest request, HttpServletResponse response
			,String orderId) throws UnsupportedEncodingException {
		
		
		Integer userId =  (Integer) request.getSession().getAttribute("userId");
		String id = request.getParameter("orderId");				
		
		String callback = request.getParameter("callback"); 
		JSONObject json = new JSONObject();
		response.setContentType("text/javascript");
		if(userId>0) {
			try {
				JSONObject jsonobject = iOrderDetail.querOrderById(id);
//				List <OrderDetail> list =iOrderDetail.queryOrder(order);
//				iOrder.addOrder("", order);
				json.put("json", jsonobject);
				json.put("returnCode", "000000");
		        json.put("returnMsg", "成功");
			}catch(Exception e){
				json.put("returnCode", "111111");
		        json.put("returnMsg", "服务器异常");
				log.info("错误异常"+e);
			}
		}
		log.info("--查询成功--");
		
		try {
		    PrintWriter out = response.getWriter();
			out.write(callback+'('+json+')'); 
	        out.flush(); 
	        log.info("--回调数据成功成功--");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}

}
