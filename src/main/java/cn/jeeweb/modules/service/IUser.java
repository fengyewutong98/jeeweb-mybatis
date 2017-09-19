package cn.jeeweb.modules.service;

import java.util.List;
import java.util.Map;

import cn.jeeweb.modules.entity.User;

/**
 * 
 * @author lixiaofei
 * 2015年10月09日
 */
public interface IUser{

	
	/**
	 * 新增
	 * @param user
	 * @param tenantId 租户id
	 * @return
	 * @throws BusinessException
	 */
	int addUser(String tenantId,User  user);
	
	/**
	 * 更新
	 * @param tenantId 租户id
	 * @param user
	 * @return
	 * @throws BusinessException
	 */
	int updateUser(String tenantId,User  user);

	/**
	 * 根据id查询
	 * @param tenantId 租户id
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	User getUser(String tenantId,int id);
	/**
	 * 根据电话查询
	 * @param phone
	 * @return
	 */
	public User getUser(String phone);
	
}