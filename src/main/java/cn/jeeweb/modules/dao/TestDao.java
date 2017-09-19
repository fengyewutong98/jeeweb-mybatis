package cn.jeeweb.modules.dao;

import java.util.List;
import java.util.Map;

import cn.jeeweb.modules.entity.Test;

/**
 * 
 * @author lixiaofei
 * 2015年5月13日
 */

public interface TestDao {

	//新增
	public int insert(Test  test);
	//查询
	public List<Test> getTestList(Map<String,Object> condition);
	
	
	
}