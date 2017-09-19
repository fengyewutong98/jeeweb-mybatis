package cn.jeeweb.modules.service;

import java.util.List;
import java.util.Map;

import cn.jeeweb.modules.entity.Test;

/**
 * 
 * @author lixiaofei
 * 2015年5月13日
 */
public interface ITestService {
	/**
	 * 新增
	 * @param test
	 * @return
	 * @throws BusinessException
	 */
	public int add(Test  test);
	/**
	 * 新增
	 * @param test
	 * @return
	 * @throws BusinessException
	 */
	List<Test> getTestList(Map<String,Object> condition);

}