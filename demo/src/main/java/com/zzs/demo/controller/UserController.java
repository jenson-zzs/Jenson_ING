package com.zzs.demo.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zzs.demo.DO.User;
import com.zzs.demo.service.LoginService;

@Controller
public class UserController {
	@Autowired
	private LoginService loginService;
	
//	@PostMapping("/doLogin")
	@RequestMapping("/doLogin")
	public ModelAndView login(@ModelAttribute("User") User user) {
		ModelAndView view = new ModelAndView("login");
		boolean flag = loginService.login(user.getAccount(), user.getPwd());
		if(flag) {
			view.addObject("account", user.getAccount());
			view.setViewName("home");
		}
		return view;
		
	}
	
//	@PostMapping("/doRegister")
	@RequestMapping("/doRegister")
	@ResponseBody
	//@RequestParam("account") String account, @RequestParam("pwd") String pwd
	public ActionResult register(@ModelAttribute User user) {
		ActionResult actionResult = new ActionResult();
		int i=loginService.register(user);
		return actionResult;
		
	}
	
	@RequestMapping("/hello")
	@ResponseBody
	public String hello( ) { 
		return "Hello World";
	}
}
