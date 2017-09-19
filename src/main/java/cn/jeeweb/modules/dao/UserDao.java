package cn.jeeweb.modules.dao;

import java.util.*;

import org.apache.ibatis.annotations.Param;

import cn.jeeweb.modules.entity.User;


/**
 * 
 * @author lixiaofei
 * 2015年7月14日
 */
public interface UserDao {

	/**
	 * 新增
	 * @param user
	 * @return
	 */
	int addUser(User  user);
	
	/**
	 * 根据id更新
	 * @param user 
	 * @return
	 */
	int updateUser(User  user);
	
	/**
	 * 根据id查询
	 * @param tenantId 租户id
	 * @param id
	 * @return
	 */
	User getUserById(@Param("tenantId")String tenantId,@Param("id")int id);

	
	/**
	 * 根据电话
	 * @param phone
	 * @return
	 */

	User getUserByPhone(String mobile);
	
	
	
}