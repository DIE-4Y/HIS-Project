package edu.nenu.hisserver.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean {
	private Long total;
	private List rows;
}

//public class PageBean {
//	private int pageSize;
//	private int currentPage;
//	private int totalPage;
//	private int totalCount;
//	private List<Register> registerList = new ArrayList<Register>();
//	private List<Integer> countList =new ArrayList<Integer>();
//	public PageBean() {};
//	public PageBean(int pageSize, int currentPage, int totalCount, int totalPage, List<Register> registerList,List<Integer> countList) {
//		this.pageSize = pageSize;
//		this.currentPage = currentPage;
//		this.totalPage = totalPage;
//		this.totalCount = totalCount;
//		this.registerList = registerList;
//		this.countList=countList;
//	}
//
//	public List<Integer> getCountList() {
//		return countList;
//	}
//	public void setCountList(List<Integer> countList) {
//		this.countList = countList;
//	}
//	public int getPageSize() {
//		return pageSize;
//	}
//	public void setPageSize(int pageSize) {
//		this.pageSize = pageSize;
//	}
//	public int getCurrentPage() {
//		return currentPage;
//	}
//	public void setCurrentPage(int currentPage) {
//		this.currentPage = currentPage;
//	}
//	public int getTotalPage() {
//		return totalPage;
//	}
//	public void setTotalPage(int totalPage) {
//		this.totalPage = totalPage;
//	}
//	public int getTotalCount() {
//		return totalCount;
//	}
//	public void setTotalCount(int totalCount) {
//		this.totalCount = totalCount;
//	}
//	public List<Register> getRegisterList() {
//		return registerList;
//	}
//	public void setRegisterList(List<Register> registerList) {
//		this.registerList = registerList;
//	}
//
//}
