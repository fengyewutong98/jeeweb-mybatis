package cn.jeeweb.modules.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;

import cn.jeeweb.modules.dao.AddressDao;
import cn.jeeweb.modules.entity.Address;
import cn.jeeweb.modules.service.IAddress;


/**
 * 
 * @author lixiaofei
 * 2015年10月9日
 */
@Service("addressService")
public class AddressImpl implements IAddress{

	@Autowired
	private AddressDao addressDao;

	@Override
	public int addAddress(String tenantId, Address address) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delAddress(String tenantId, int[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delAddress(String tenantId, int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateAddress(String tenantId, Address address) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Address getAddress(String tenantId, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address getAddress(String tenantId, String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Address> getAddressList(String tenantId, Map<String, Object> condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Address> getPageAddress(String tenantId, Map<String, Object> condition, Page<Address> page) {
		// TODO Auto-generated method stub
		return null;
	}
	

	
	
	
}