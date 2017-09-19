package cn.jeeweb.modules.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;

import cn.jeeweb.modules.entity.ProductDetail;
import cn.jeeweb.modules.service.IProductDetail;
import net.sf.json.JSONArray;

@Controller
@RequestMapping(value="/product")
public class ProductController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private IProductDetail iProductDetail;
	

	@RequestMapping(value="/list")
	@ResponseBody
	public void query(HttpServletRequest request, HttpServletResponse response,
			int page,ProductDetail productDetail ){
		
		Map<String,Object> condition = new HashMap<>();
		
		condition.put("page", 10*(page-1));
		condition.put("limit", 10);
		if(productDetail.getProductBelogTwoCategoryId()>0) {
			condition.put("productBelogTwoCategoryId",productDetail.getProductBelogTwoCategoryId());
		}else {
			condition.put("productBelogThreeCategoryId",productDetail.getProductBelogThreeCategoryId());
		} 
	
		List<ProductDetail> list= iProductDetail.getProductDetailList("",condition);
		JSONArray json = JSONArray.fromObject(list); 
		log.info(json);
		String callback = request.getParameter("callback");  
        response.setContentType("text/javascript");  
		try {
		    PrintWriter out = response.getWriter();
			out.write(callback+'('+json+')'); 
	        out.flush(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
	@RequestMapping(value="/getid")
	@ResponseBody
	public void queryone(HttpServletRequest request, HttpServletResponse response,
			ProductDetail productDetail ){
		
		if(productDetail.getProductId()>0) {
			ProductDetail  product = iProductDetail.getProductDetail(productDetail.getProductId());
			
			JSONObject jsonObject = JSONObject.fromObject(product);
			log.info(jsonObject);
			String callback = request.getParameter("callback");  
	        response.setContentType("text/javascript");  
			try {
			    PrintWriter out = response.getWriter();
				out.write(callback+'('+jsonObject+')'); 
		        out.flush(); 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}

}
