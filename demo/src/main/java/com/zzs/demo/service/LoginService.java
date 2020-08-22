package com.zzs.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.zzs.demo.DO.User;

public interface LoginService {
	public Boolean login(String account, String pwd);

	public int register(User user);
}
