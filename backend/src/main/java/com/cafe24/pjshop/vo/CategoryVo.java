package com.cafe24.pjshop.vo;

public class CategoryVo {

	private Long no;
	private String name;
	private Long depth;
	private Long parentsNo;
	private Long groupNo;
	
	public CategoryVo() {
		// TODO Auto-generated constructor stub
	}

	public CategoryVo(Long no, String name, Long depth, Long parentsNo, Long groupNo) {
		this.no = no;
		this.name = name;
		this.depth = depth;
		this.parentsNo = parentsNo;
		this.groupNo = groupNo;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getDepth() {
		return depth;
	}

	public void setDepth(Long depth) {
		this.depth = depth;
	}

	public Long getParentsNo() {
		return parentsNo;
	}

	public void setParentsNo(Long parentsNo) {
		this.parentsNo = parentsNo;
	}

	public Long getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(Long groupNo) {
		this.groupNo = groupNo;
	}

	@Override
	public String toString() {
		return "CategoryVo [no=" + no + ", name=" + name + ", depth=" + depth + ", parentsNo=" + parentsNo
				+ ", groupNo=" + groupNo + "]";
	}
	
	
}
