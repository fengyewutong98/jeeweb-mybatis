package cn.jeeweb.modules.dao;



import java.util.*;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.plugins.Page;

import cn.jeeweb.modules.entity.Address;

/**
 * 
 * @author lixiaofei
 * 2015年7月14日
 */
public interface AddressDao {

	/**
	 * 新增
	 * @param address
	 * @return
	 */
	int addAddress(Address  address);
	
	/**
	 * 根据id删除
	 * @param tenantId 租户id
	 * @param id
	 * @return
	 */
	int delAddress(@Param("tenantId")String tenantId,@Param("id")int id);
	
	/**
	 * 根据id更新
	 * @param address 
	 * @return
	 */
	int updateAddress(Address  address);
	
	/**
	 * 根据id查询
	 * @param tenantId 租户id
	 * @param id
	 * @return
	 */
	Address getAddressById(@Param("tenantId")String tenantId,@Param("id")int id);

	/**
	 * 根据code查询
	 * @param tenantId 租户id
	 * @param code
	 * @return
	 */
	Address getAddressByCode(@Param("tenantId")String tenantId,@Param("code")String code);
	
	/**
	 * 根据条件查询所有列表
	 * @param condition
	 * @return
	 */
	List<Address> getAddressList(Map<String,Object> condition);
	
	
	
	
	
}