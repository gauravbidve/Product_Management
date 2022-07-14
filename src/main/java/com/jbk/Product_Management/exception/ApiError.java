package com.jbk.Product_Management.exception;

import java.util.List;

public class ApiError {

	String errorMsg;
	List<String> list;

	public ApiError() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApiError(String errorMsg, List<String> list) {
		super();
		this.errorMsg = errorMsg;
		this.list = list;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "ApiError [errorMsg=" + errorMsg + ", list=" + list + "]";
	}

}
