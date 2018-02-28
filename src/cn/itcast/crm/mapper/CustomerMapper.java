package cn.itcast.crm.mapper;

import java.util.List;

import cn.itcast.crm.pojo.Customer;
import cn.itcast.crm.pojo.QueryVo;

public interface CustomerMapper {


	//查询总条数     符合条件
	public Integer countCustomerByQueryVo(QueryVo vo);
	//查询结果集  符合条件
	public List<Customer> findCustomerListByQueryVo(QueryVo vo);
	
	//通过客户ID查询客户对象 并以Json格式返回此对象
	public Customer findCustomerById(Integer id);
	
	//保存修改
	public void updateCustomerById(Customer customer);
	//删除
	public void deleteCustomerById(Integer id);

}
