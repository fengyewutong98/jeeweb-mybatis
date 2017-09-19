package cn.jeeweb.modules.service;

import java.util.List;
import java.util.Map;

import cn.jeeweb.modules.entity.Category;


/**
 * 
 * @author lixiaofei
 * 2015年10月09日
 */
public interface ICategory{

	
	/**
	 * 根据条件查询所有列表
	 * @param tenantId 租户id
	 * @param condition
	 * @return
	 * @throws BusinessException
	 */
	List<Category> getCategoryList(Map<String, Object> condition);
	
}