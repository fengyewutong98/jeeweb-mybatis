package cn.jeeweb.modules.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jeeweb.modules.dao.AddressDao;
import cn.jeeweb.modules.dao.CategoryDao;
import cn.jeeweb.modules.entity.Category;
import cn.jeeweb.modules.service.ICategory;

@Service("categoryService")
public class CategoryImpl implements ICategory {
	
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private AddressDao addressDao;
	
	@Override
	public List<Category> getCategoryList( Map<String, Object> condition) {
		// TODO Auto-generated method stub
		return categoryDao.getCategoryList(condition);
	}

}
