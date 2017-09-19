package cn.jeeweb.modules.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jeeweb.modules.dao.UserDao;
import cn.jeeweb.modules.entity.User;
import cn.jeeweb.modules.service.IUser;

/**
 * 
 * @author lixiaofei
 * 2015年10月9日
 */
@Service("userService")
public class UserImpl implements IUser{

	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private UserDao userDao;

	@Override
	public int addUser(String tenantId, User user) {
		// TODO Auto-generated method stub
		log.info("service增加个人信息");
		return userDao.addUser(user);
	}

	@Override
	public int updateUser(String tenantId, User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User getUser(String tenantId, int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public User getUser(String phone) {
		// TODO Auto-generated method stub
		return userDao.getUserByPhone(phone);
	}
	
	
	
	
}