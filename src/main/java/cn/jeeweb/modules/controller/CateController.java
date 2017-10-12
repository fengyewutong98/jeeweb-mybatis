package cn.jeeweb.modules.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jeeweb.modules.common.util.RequestFilter;
import cn.jeeweb.modules.service.IProductCart;
import cn.jeeweb.modules.service.IShoppingCart;
import net.sf.json.JSONObject;

@Controller
@RequestMapping(value="/cate")
public class CateController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private IShoppingCart iShoppingCart;
	@Autowired
	private IProductCart iProductCart;
	
	
	/**
	 * 商品添加购物车 
	 * @param request
	 * @param response
	 * @param productId
	 * @param userphone
	 * @param num
	 */
	@RequestMapping(value="/createcate")
	@ResponseBody
	public void query(HttpServletRequest request, HttpServletResponse response,
			String productId,String userphone,String num){
		log.info("添加购物车");
	    request = RequestFilter.threadLocalRequest.get();
	    String  phone = (String) request.getSession().getAttribute("phone");
	    log.info(phone);
		log.info("--添加成功--");
		String callback = request.getParameter("callback"); 
		JSONObject json = new JSONObject();
		response.setContentType("text/javascript");
	    if(phone == null) {
	        json.put("returnCode", "111111");
	        json.put("returnMsg", "请登录失败");
	    }else {
	    	try {
	    		iShoppingCart.addShoppingCart(phone, Integer.valueOf(num), productId);
	    		 json.put("returnCode", "000000");
		         json.put("returnMsg", "成功");
	    	} catch (Exception e) {
				// TODO: handle exception
	    		log.info(e);
	    		json.put("returnCode", "111111");
		        json.put("returnMsg", "服务器异常");
			}
	    }
		
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
	 * 购物车查询
	 * @param request
	 * @param response
	 * @param productId
	 * @param userphone
	 * @param num
	 */
	@RequestMapping(value="/querycart")
	@ResponseBody
	public void querycart(HttpServletRequest request, HttpServletResponse response,
			String userphone){
		log.info("查询购物车");
	    request = RequestFilter.threadLocalRequest.get();
	    String  phone = (String) request.getSession().getAttribute("phone");
	    log.info(phone);
		log.info("--添加成功--");
		String callback = request.getParameter("callback"); 
		JSONObject json = new JSONObject();
		response.setContentType("text/javascript");
	    if(phone == null) {
	        json.put("returnCode", "111111");
	        json.put("returnMsg", "请登录失败");
	    }else {
	    	try {
	    		JSONObject jsonobject = iShoppingCart.querycart(phone);
	    		 json.put("jsonobject", jsonobject);
	    		 json.put("returnCode", "000000");
		         json.put("returnMsg", "成功");
	    	} catch (Exception e) {
				// TODO: handle exception
	    		log.info(e);
	    		json.put("returnCode", "111111");
		        json.put("returnMsg", "服务器异常");
			}
	    }
		
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
	 * 删除购物车
	 * @param request
	 * @param response
	 * @param productId
	 * @param userphone
	 * @param num
	 */
	@RequestMapping(value="/deletecart")
	@ResponseBody
	public void deletecart(HttpServletRequest request, HttpServletResponse response,
			String carId,String productId){
		log.info("删除商品购物车里的");
		log.info("--添加成功--");
		String callback = request.getParameter("callback"); 
		JSONObject json = new JSONObject();
		response.setContentType("text/javascript");
    	try {
    		 iProductCart.delProductCart(carId, productId);
    		 json.put("returnCode", "000000");
	         json.put("returnMsg", "成功");
    	} catch (Exception e) {
			// TODO: handle exception
    		log.info(e);
    		json.put("returnCode", "111111");
	        json.put("returnMsg", "服务器异常");
		}
		
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
