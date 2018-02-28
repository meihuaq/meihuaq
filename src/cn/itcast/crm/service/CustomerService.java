package cn.itcast.crm.service;

import java.util.List;

import cn.itcast.common.utils.Page;
import cn.itcast.crm.pojo.BaseDict;
import cn.itcast.crm.pojo.Customer;
import cn.itcast.crm.pojo.QueryVo;

public interface CustomerService {
	
	// 客户来源 002
	// 所属行业 001
	// 客户级别 006
	
	public List<BaseDict> findBaseDictListByTypeCode(String typeCode);
	
	
	//通过条件查询分页对象
	public Page<Customer> findPageByQueryVo(QueryVo vo);
	
	//通过客户ID查询客户对象 并以Json格式返回此对象
	public Customer findCustomerById(Integer id);
	
	//保存修改
	public void updateCustomerById(Customer customer);
	
	//删除
	public void deleteCustomerById(Integer id);

}
