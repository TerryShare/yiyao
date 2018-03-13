package com.lyh.util;

import javax.servlet.http.HttpServletRequest;

public class Page {
	// ��ǰҳ
	private Integer currentPage=0;
	// ÿҳ��ʾ������
	private Integer lineSize=5;
	
	
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

	@Override
	public String toString() {
		return "Page [currentPage=" + currentPage + ", lineSize=" + lineSize
				+ ", getCurrentPage()=" + getCurrentPage() + ", getLineSize()="
				+ getLineSize() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	// ��ȡ��ǰҳ
	public void initPage(HttpServletRequest request) {
		String page_str = request.getParameter("pager.offset");
		if (page_str != null && !page_str.equals("")) {
			this.currentPage = Integer.parseInt(page_str);
		}
	}

}
