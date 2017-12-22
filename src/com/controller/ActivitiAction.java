package com.controller;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.spi.http.HttpContext;

import org.activiti.engine.history.HistoricTaskInstance;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.service.IActivitiServiceImpl;

@Controller
@RequestMapping("/act")
public class ActivitiAction{

	@Autowired
	private IActivitiServiceImpl service;
	
	@RequestMapping("/add")
	public ModelAndView addAct(HttpServletRequest req,@RequestParam("upload")MultipartFile upload,String name){
		String path = req.getSession().getServletContext().getRealPath("/flow");  
		File file = new File(path, upload.getOriginalFilename());
		try {
			upload.transferTo(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		service.addAct(file.getPath(), name);
		return new ModelAndView("redirect:/act/findAll.do");
	}
	
	@RequestMapping("/findAll")
	public ModelAndView findAll(ModelAndView model){
		model.addObject("list", service.findAllAct());
		model.setViewName("ActManage");
		return model;
	}
	
	@RequestMapping("/delete")
	public ModelAndView deleteAct(String id){
		service.deleteAct(id);
		return new ModelAndView("redirect:/act/findAll.do");
	}
	
	@RequestMapping("/begin")
	public ModelAndView beginAct(String flow,String name,String why,String time,String startTime){
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(name);
		map.put("userId", name);
		map.put("userId1", "小李");
		map.put("userId2", "小王");
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("why", why);
		map1.put("time", time);
		map1.put("startTime", startTime);
		service.beginAct(flow, map,name, map1);	
		return new ModelAndView("redirect:/act/findAll.do");
	}
	@RequestMapping("/check")
	public ModelAndView check(String name,String idea1,String idea2){
		Map<String, Object> map = new HashMap<String, Object>();
		if(idea1!=null&&!idea1.equals(""))map.put("report1", idea1);
		if(idea2!=null&&!idea2.equals(""))map.put("report2", idea2);		
		service.check(name, map);
		return new ModelAndView("redirect:/act/findAll.do");
	}
	@RequestMapping("/look")
	public ModelAndView lookCheck(String name,ModelAndView model){
		model.addObject("l", service.findAct(name));
		model.setViewName("check");
		return model;
	}
	@RequestMapping("/plan")
	public ModelAndView plan(String name,ModelAndView model){
		Map<String, Object> plan = service.plan(name);
		if(plan!=null){
			List<HistoricTaskInstance> tlist = (List<HistoricTaskInstance>) plan.get("t");
			List<Map<String, Object>> vlist = (List<Map<String, Object>>) plan.get("v");
			model.addObject("tlist",tlist);
			model.addObject("vlist", vlist);
		}
		model.setViewName("plan");
		return model;
	}
}
