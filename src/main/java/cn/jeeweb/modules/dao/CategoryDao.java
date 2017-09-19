package cn.jeeweb.modules.dao;


import java.util.*;


import cn.jeeweb.modules.entity.Category;


/**
 * 
 * @author lixiaofei
 * 2015年7月14日
 */
public interface CategoryDao {
	
	/**
	 * 根据条件查询所有列表
	 * @param condition
	 * @return
	 */
	public List<Category> getCategoryList(Map<String,Object> condition);

	
	
}