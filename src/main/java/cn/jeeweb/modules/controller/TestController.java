package cn.jeeweb.modules.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jeeweb.modules.entity.Test;
import cn.jeeweb.modules.service.ITestService;


@Controller
@RequestMapping(value="/test")
public class TestController {
	@Autowired
	private ITestService iTestService;
	
	@RequestMapping(value="/test")
	@ResponseBody
	public String getpic(String a){
		
		for(int i =0;i<10;i++) {
			Test test = new Test();
			test.setSysname("由冠宇");
			test.setFaceType(""+i);
			test.setFaceSys("123");
			test.setFaceTable("shop");
			test.setFaceRate(""+i);
			iTestService.add(test);	
		}
		
		return a;
	}
	@RequestMapping(value="/get")
	@ResponseBody
	public Map<String,Object> query(String a){
		Map<String,Object> map = new HashMap<>(); 
		Map<String,Object> condition = new HashMap<>();
		condition.put("faceType", "1");
		List<Test> list = iTestService.getTestList(condition);
		map.put("list",list);
		return map;
	}
}
