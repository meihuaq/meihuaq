package cn.itcast.crm.pojo;

public class QueryVo {
	
	//每页显示的条数 常量值
	public static final Integer SIZE = 10;
	
	//客户名称
	private String custName;
	//客户来源
	private String custSource;
	//所属行业
	private String custIndustry;
	//客户级别
	private String custLevel;
	//当前页
	private Integer page = 1;
	//每页数
	private Integer size = SIZE;
	//开始行
	private Integer startRow;
	
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public Integer getStartRow() {
		return startRow;
	}
	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustSource() {
		return custSource;
	}
	public void setCustSource(String custSource) {
		this.custSource = custSource;
	}
	public String getCustIndustry() {
		return custIndustry;
	}
	public void setCustIndustry(String custIndustry) {
		this.custIndustry = custIndustry;
	}
	public String getCustLevel() {
		return custLevel;
	}
	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	
	

}