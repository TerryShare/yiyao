package com.lyh.util;

public class BaseBean {
	private Integer currentPage;//当前页数  
	private Integer lineSize;//每页显示多少条

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getLineSize() {
		return lineSize;
	}

	public void setLineSize(Integer lineSize) {
		this.lineSize = lineSize;
	}

}
