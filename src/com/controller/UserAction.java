package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.entity.UserEntity;
import com.service.IUserService;
import com.util.Util;
@Controller
@RequestMapping("/user")
public class UserAction {
	
	@Autowired
	private IUserService service;
	
	@RequestMapping("/login")
	public ModelAndView login(HttpSession session,UserEntity u){
		UserEntity login = service.login(u);
		if(login!= null){
			session.setAttribute("usr", login);
			return new ModelAndView("redirect:/user/findAll.do");
		}else{
			return new ModelAndView("login");
		}
	}
	@RequestMapping("/exit")
	public ModelAndView exit(HttpSession session){
		session.invalidate();
		return new ModelAndView("login");
	}
	@RequestMapping("/add")
	public ModelAndView addUser(UserEntity u){
		u.setId(Util.getUUID());
		service.addUser(u);
		return new ModelAndView("redirect:/user/findAll.do");
	}
	@RequestMapping("/delete")
	public ModelAndView deleteUser(String id){
		service.deleteUser(id);
		return new ModelAndView("redirect:/user/findAll.do");
	}
	@RequestMapping("/update")
	public ModelAndView updateUser(UserEntity u){
		service.updateUser(u);
		return new ModelAndView("redirect:/user/findAll.do");
	}
	@RequestMapping("/findAll")
	public ModelAndView findAll(ModelAndView model){
		model.addObject("list", service.findAll());
		model.setViewName("index");
		return model;
	}
	@RequestMapping("findById")
	public ModelAndView findById(String id,ModelAndView model){
		model.addObject("user", service.findById(id));
		model.setViewName("aAu");
		return model;
	}
}
