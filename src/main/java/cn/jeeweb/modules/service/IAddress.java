package cn.jeeweb.modules.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.plugins.Page;

import cn.jeeweb.modules.entity.Address;


/**
 * 
 * @author lixiaofei
 * 2015年10月09日
 */
public interface IAddress{

	
	/**
	 * 新增
	 * @param address
	 * @param tenantId 租户id
	 * @return
	 * @throws BusinessException
	 */
	int addAddress(String tenantId,Address  address);
	
	/**
	 * 根据ids删除
	 * @param tenantId 租户id
	 * @param ids
	 * @return
	 * @throws BusinessException
	 */
	int delAddress(String tenantId,int[] ids);
	
	/**
	 * 根据id删除
	 * @param tenantId 租户id
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	int delAddress(String tenantId,int id);
	
	/**
	 * 更新
	 * @param tenantId 租户id
	 * @param address
	 * @return
	 * @throws BusinessException
	 */
	int updateAddress(String tenantId,Address  address);

	/**
	 * 根据id查询
	 * @param tenantId 租户id
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	Address getAddress(String tenantId,int id);
	
	/**
	 * 根据code查询
	 * @param tenantId 租户id
	 * @param code
	 * @return
	 * @throws BusinessException
	 */
	Address getAddress(String tenantId,String code);
	
	/**
	 * 根据条件查询所有列表
	 * @param tenantId 租户id
	 * @param condition
	 * @return
	 * @throws BusinessException
	 */
	List<Address> getAddressList(String tenantId,Map<String, Object> condition);
	
	/**
	 * 带分页查询
	 * @param tenantId 租户id
	 * @param condition
	 * @param page 分页
	 * @return
	 * @throws BusinessException
	 */
	Page<Address> getPageAddress(String tenantId,Map<String,Object> condition,Page<Address> page);
	/**
	 * 查询当前用户地址信息
	 * @param phone
	 * @return
	 */
	List<Address> queryAddress(Integer userId);
}