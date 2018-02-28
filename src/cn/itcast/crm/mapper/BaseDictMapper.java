package cn.itcast.crm.mapper;

import java.util.List;

import cn.itcast.crm.pojo.BaseDict;

public interface BaseDictMapper {

	// 客户来源 002
	// 所属行业 001
	// 客户级别 006
	
	public List<BaseDict> findBaseDictListByTypeCode(String typeCode);
	
	

}
