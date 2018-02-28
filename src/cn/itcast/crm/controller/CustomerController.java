package cn.itcast.crm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.common.utils.Page;
import cn.itcast.crm.pojo.BaseDict;
import cn.itcast.crm.pojo.Customer;
import cn.itcast.crm.pojo.QueryVo;
import cn.itcast.crm.service.CustomerService;

/**
 * 客户管理
 * 客户列表（条件  分页）
 * 客户修改
 * 客户删除
 * 客户添加（同学们）
 * @author lx
 *
 */
@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	//客户来源 002
	@Value(value="${crm.fromType}")
	private String ft;
	//所属行业  001
	@Value(value="${crm.industryType}")
	private String it;
	//客户级别  006
	@Value(value="${crm.levelType}")
	private String lt;
	
	
	
	
	//进入客户管理列表页面
	@RequestMapping(value = "/customer/list.action")
	public String list(QueryVo vo, Model model,HttpServletRequest request){
		
		
		
		//客户来源 002
		//所属行业  001
		//客户级别  006
		List<BaseDict> fromType = customerService.findBaseDictListByTypeCode(ft);
		List<BaseDict> industryType = customerService.findBaseDictListByTypeCode(it);
		List<BaseDict> levelType = customerService.findBaseDictListByTypeCode(lt);
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		
		//通过条件查询分页对象
		Page<Customer> page = customerService.findPageByQueryVo(vo);
		model.addAttribute("page", page);
		model.addAttribute("custName", vo.getCustName());
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		model.addAttribute("custLevel", vo.getCustLevel());
	
		
		return "customer";
	}
	
	//通过客户ID查询客户对象 并以Json格式返回此对象
	@RequestMapping(value = "customer/edit.action")
	@ResponseBody
	public Customer edit(Integer id){
		return customerService.findCustomerById(id);//Shift + Ctrl + i
	}
	//保存修改
	@RequestMapping(value = "customer/update.action")
	@ResponseBody
	public String update(Customer customer){
		//修改
		customerService.updateCustomerById(customer);
		return "OK";
	}
	//删除
	@RequestMapping(value = "customer/delete.action")
	@ResponseBody
	public String delete(Integer id){
		//删除
		customerService.deleteCustomerById(id);
		return "OK";
	}
	
}
