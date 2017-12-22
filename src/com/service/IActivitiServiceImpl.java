package com.service;

import java.util.List;
import java.util.Map;

import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.IActivitiDaoImpl;
@Service
public class IActivitiServiceImpl implements IActivitiService{

	@Autowired
	private IActivitiDaoImpl dao;
	
	@Override
	public void addAct(String url, String name) {
		dao.addAct(url, name);
		
	}

	@Override
	public void deleteAct(String id) {
		dao.deleteAct(id);
		
	}

	@Override
	public List<ProcessDefinition> findAllAct() {
		
		return dao.findAllAct();
	}

	@Override
	public void beginAct(String flow, Map<String, Object> map,String name, Map<String, Object> map1) {
		dao.beginAct(flow, map,name,map1);
		
	}

	@Override
	public void check(String name, Map<String, Object> map) {
		dao.check(name, map);
		
	}

	@Override
	public List<Map<String, Object>> findAct(String name) {
		
		return dao.findAct(name);
	}

	@Override
	public Map<String, Object> plan(String name) {
		
		return dao.plan(name);
	}

}
