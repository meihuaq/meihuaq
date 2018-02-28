package cn.itcast.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.common.utils.Page;
import cn.itcast.crm.mapper.BaseDictMapper;
import cn.itcast.crm.mapper.CustomerMapper;
import cn.itcast.crm.pojo.BaseDict;
import cn.itcast.crm.pojo.Customer;
import cn.itcast.crm.pojo.QueryVo;

/**
 * 客户管理
 * @author lx
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	
	@Autowired
	private BaseDictMapper baseDictMapper;
	@Autowired
	private CustomerMapper customerMapper;
	// 客户来源 002
	// 所属行业 001
	// 客户级别 006
	public List<BaseDict> findBaseDictListByTypeCode(String typeCode){
		return baseDictMapper.findBaseDictListByTypeCode(typeCode);
	}
	
	//通过条件查询分页对象
	public Page<Customer> findPageByQueryVo(QueryVo vo){
		if(null != vo.getCustName()){
			vo.setCustName(vo.getCustName().trim());
		}
		
		//创建分页对象
		Page<Customer> page = new Page<Customer>();
		//当前页
		page.setPage(vo.getPage());
		//每页数
		page.setSize(vo.getSize());
		//总条数
		page.setTotal(customerMapper.countCustomerByQueryVo(vo));
		//计算开始行
		vo.setStartRow((vo.getPage()-1)*vo.getSize());
		//结果集
		page.setRows(customerMapper.findCustomerListByQueryVo(vo));
		
		return page;
	}
	//通过客户ID查询客户对象 并以Json格式返回此对象
	public Customer findCustomerById(Integer id){
		return customerMapper.findCustomerById(id);
	}
	
	//保存修改
	public void updateCustomerById(Customer customer){
		customerMapper.updateCustomerById(customer);
	}
	//删除
	public void deleteCustomerById(Integer id){
		customerMapper.deleteCustomerById(id);
	}
}
