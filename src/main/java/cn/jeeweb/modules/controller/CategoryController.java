package cn.jeeweb.modules.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import cn.jeeweb.modules.entity.Category;
import cn.jeeweb.modules.service.ICategory;
import net.sf.json.JSONArray;
/**
 * 商品分类
 * @author championyo
 *
 */
@Controller
@RequestMapping(value="/category")
public class CategoryController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private ICategory iCategory;
	
	@RequestMapping(value="/get")
	@ResponseBody
	public void query(HttpServletRequest request, HttpServletResponse response,String categoryLeve,String belongFirstLeve){
		
		Map<String,Object> condition = new HashMap<>();
		
		if(StringUtils.isNotBlank(categoryLeve))condition.put("categoryLeve", categoryLeve);
		if(StringUtils.isNotBlank(belongFirstLeve))condition.put("belongFirstLeve", belongFirstLeve);
		List<Category> list = iCategory.getCategoryList(condition);
		JSONArray json = JSONArray.fromObject(list); 
		log.info("--查询成功--"+json);
		String callback = request.getParameter("callback");  
        response.setContentType("text/javascript");  
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
