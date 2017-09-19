package cn.jeeweb.modules.service.impl;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.jeeweb.modules.dao.TestDao;
import cn.jeeweb.modules.entity.Test;
import cn.jeeweb.modules.service.ITestService;


/**
 * 
 * @author lixiaofei
 * 2015年5月13日
 */
@Service("testService")
public class TestServiceImpl implements ITestService{

	@Autowired
	private TestDao testDao;

	@Override
	public int add(Test test) {
		// TODO Auto-generated method stub
		testDao.insert(test);
		return 0;
	}

	@Override
	public List<Test> getTestList(Map<String,Object> condition) {
		// TODO Auto-generated method stub
		return testDao.getTestList(condition);
	}
	
}
	

