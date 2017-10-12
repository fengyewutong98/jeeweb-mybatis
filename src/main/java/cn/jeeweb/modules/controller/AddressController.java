package cn.jeeweb.modules.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jeeweb.modules.common.util.RequestFilter;
import cn.jeeweb.modules.entity.Address;
import cn.jeeweb.modules.service.IAddress;
import net.sf.json.JSONObject;

/**
 * 地址查询添加
 * @author championyo
 *
 */
@Controller
@RequestMapping(value="/address")
public class AddressController {

	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private IAddress iAddress;
	/**
	 * 购物车模块选择地址还是添加地址
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/queryaddress")
	@ResponseBody
	public void queryAddress(HttpServletRequest request, HttpServletResponse response){
		log.info("查询地址");
	    request = RequestFilter.threadLocalRequest.get();
	    String  phone = (String) request.getSession().getAttribute("phone");
	    Integer  userId = (Integer) request.getSession().getAttribute("userId");
		log.info("--添加成功--");
		String callback = request.getParameter("callback"); 
		JSONObject json = new JSONObject();
		response.setContentType("text/javascript");
	    if(phone == null) {
	        json.put("returnCode", "111111");
	        json.put("returnMsg", "请登录失败");
	    }else {
	    	try {
	    		List<Address> list = iAddress.queryAddress(userId);
	    		 json.put("list", list);
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
	 * 添加地址
	 * @param request
	 * @param response
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value="/saveaddress",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE +";charset=UTF-8")
	@ResponseBody
	public void saveaddress(HttpServletRequest request, HttpServletResponse response,
			Address address ) throws UnsupportedEncodingException{
		log.info("插入地址");
		request.setCharacterEncoding("UTF-8"); 
        String recipients=request.getParameter("recipients"); 
        String addressDetail =request.getParameter("addressDetail"); 
        String telephone =request.getParameter("telephone"); 
        recipients = URLDecoder.decode(recipients, "utf-8");
        addressDetail= URLDecoder.decode(addressDetail, "utf-8");
        log.info(addressDetail+"----"+recipients);
        address.setRecipients(recipients);
        address.setAddressDetail(addressDetail);
	    request = RequestFilter.threadLocalRequest.get();
	    String  phone = (String) request.getSession().getAttribute("phone");
	    Integer  userId = (Integer) request.getSession().getAttribute("userId");
	    address.setUserId(userId);
	    address.setTelephone(telephone);
		log.info("--添加成功--");
		String callback = request.getParameter("callback"); 
		JSONObject json = new JSONObject();
		response.setContentType("text/javascript");
	    if(phone == null) {
	        json.put("returnCode", "111111");
	        json.put("returnMsg", "请登录失败");
	    }else {
	    	try {
	    		int i = iAddress.addAddress(callback, address);
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
	 * 删除地址
	 * @param request
	 * @param response
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value="/deleteaddress",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE +";charset=UTF-8")
	@ResponseBody
	public void deleteaddress(HttpServletRequest request, HttpServletResponse response ,
			String addressId)
			throws UnsupportedEncodingException{
		log.info("删除地址");
		request.setCharacterEncoding("UTF-8"); 
	    request = RequestFilter.threadLocalRequest.get();
	    String  phone = (String) request.getSession().getAttribute("phone");
	    Integer  userId = (Integer) request.getSession().getAttribute("userId");
		log.info("--添加成功--");
		String callback = request.getParameter("callback"); 
		JSONObject json = new JSONObject();
		response.setContentType("text/javascript");
	    if(phone == null) {
	        json.put("returnCode", "111111");
	        json.put("returnMsg", "请登录失败");
	    }else {
	    	try {
	    		int i = iAddress.delAddress("", Integer.valueOf(addressId));
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
	
}
