package com.zzs.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zzs.demo.DO.User;
import com.zzs.demo.dao.UserDao;


@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	UserDao userDao;
	
	@Override
	public Boolean login(String account, String pwd) {
		User user = userDao.getUser(account, pwd);
		return (null == user || user.getDisable())? false: true;
	}

	@Override
	@Transactional
	public int register(User user) {
		int ii=userDao.insert(user);
		return ii;
	}
}
