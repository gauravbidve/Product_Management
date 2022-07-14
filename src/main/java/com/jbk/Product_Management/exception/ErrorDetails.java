package com.jbk.Product_Management.exception;

import java.util.Date;

public class ErrorDetails {

	private String msg;
	private String detailedMsg;
	private Date timeStamp;

	public ErrorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ErrorDetails(String detailedMsg, Date timeStamp) {
		super();
		this.detailedMsg = detailedMsg;
		this.timeStamp = timeStamp;
	}

	public ErrorDetails(String msg, String detailedMsg, Date timeStamp) {
		super();
		this.msg = msg;
		this.detailedMsg = detailedMsg;
		this.timeStamp = timeStamp;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getDetailedMsg() {
		return detailedMsg;
	}

	public void setDetailedMsg(String detailedMsg) {
		this.detailedMsg = detailedMsg;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

}
