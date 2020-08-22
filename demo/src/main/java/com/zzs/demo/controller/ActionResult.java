package com.zzs.demo.controller;

import java.util.Map;

public class ActionResult {
	private Boolean status;
	private String msg;
	private Map<String, Object> data;
	public Boolean getStatus() {
		return status;
	}
	public String getMsg() {
		return msg;
	}
	public Map<String, Object> getData() {
		return data;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public void setStatusAndMsg(Boolean status, String msg) {
		this.status = status;
		this.msg = msg;
	}
	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	
	public ActionResult() {
		status = true;
		msg = "Action success";
	}
	
	public ActionResult(Boolean status, String msg) {
		this.status = status;
		this.msg = msg;
	}
	
	
}
