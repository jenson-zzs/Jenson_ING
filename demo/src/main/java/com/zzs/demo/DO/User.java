package com.zzs.demo.DO;

import java.io.Serializable;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2036063146308840414L;
	private String id;
	private String name;
	private int sex;
	private String account;
	private String pwd;
	private Boolean disable;
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getAccount() {
		return account;
	}
	public String getPwd() {
		return pwd;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Boolean getDisable() {
		return disable;
	}
	public void setDisable(Boolean disable) {
		this.disable = disable;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
}
