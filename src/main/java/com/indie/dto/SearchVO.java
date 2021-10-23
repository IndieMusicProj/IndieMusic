package com.indie.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchVO {
	private String tableName;
	private String searchCondition;
	private String searchKeyword;
	
	public String getTableName() {
		return tableName;
	}


	public void setTableName(String tableName) {
		this.tableName = tableName;
	}


	public String getSearchCondition() {
		return searchCondition;
	}


	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}


	public String getSearchKeyword() {
		return searchKeyword;
	}


	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}


	@Override
	public String toString() {
		return "SearchVO [tableName=" + tableName + ", searchCondition=" + searchCondition + ", searchKeyword="
				+ searchKeyword + "]";
	}
}
