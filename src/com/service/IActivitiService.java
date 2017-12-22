package com.service;

import java.util.List;
import java.util.Map;

import org.activiti.engine.repository.ProcessDefinition;

public interface IActivitiService {

	void addAct(String url,String name);
	void deleteAct(String id);
	List<ProcessDefinition> findAllAct();
	
	
	List<Map<String, Object>> findAct(String name);
	void beginAct(String flow,Map<String, Object> map,String name, Map<String, Object> map1);
	void check(String name,Map<String, Object> map);
	Map<String, Object> plan(String name);
}
