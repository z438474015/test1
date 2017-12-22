package com.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricVariableInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.springframework.stereotype.Repository;

@Repository
public class IActivitiDaoImpl implements IActivitiDao{

	private ProcessEngine pe = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml").buildProcessEngine();
	@Override
	public void addAct(String url, String name) {
		System.out.println(url);
		InputStream in;
		try {
			in = new FileInputStream(url);
			pe.getRepositoryService().createDeployment().name(name).addZipInputStream(new ZipInputStream(in)).deploy();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void deleteAct(String id) {
		pe.getRepositoryService().deleteDeployment(id,true);
		
	}

	@Override
	public List<ProcessDefinition> findAllAct() {
		List<ProcessDefinition> list = pe.getRepositoryService().createProcessDefinitionQuery().list();
		return list;
	}

	@Override
	public void beginAct(String flow, Map<String, Object> map,String name, Map<String, Object> map1) {
		pe.getRuntimeService().startProcessInstanceByKey(flow,map);
		TaskService ts = pe.getTaskService();
		Task task = ts.createTaskQuery().taskAssignee(name).singleResult();
		ts.setVariables(task.getId(), map1);
		ts.complete(task.getId());
		
	}

	@Override
	public void check(String name, Map<String, Object> map) {
		TaskService ts = pe.getTaskService();
		Task task = ts.createTaskQuery().taskId(name).singleResult();
		ts.setVariables(task.getId(), map);
		ts.complete(task.getId());
		
	}

	@Override
	public List<Map<String, Object>> findAct(String name) {
		TaskService ts = pe.getTaskService();
		List<Task> list = ts.createTaskQuery().taskAssignee(name).list();
		if (list.size()==0) {
			return null;
		}
		List<Map<String, Object>> l = new ArrayList<Map<String, Object>>();
		for (Task task : list) {
			Map<String, Object> map = ts.getVariables(task.getId());
			map.put("taskId", task.getId());
			l.add(map);
		}
		return l;
	}

	@Override
	public Map<String, Object> plan(String name) {
		List<HistoricTaskInstance> l1 = pe.getHistoryService().createHistoricTaskInstanceQuery().taskAssignee(name).list();
		if(l1==null)return null;
		List<Map<String, Object>> l2 = new ArrayList<Map<String, Object>>();	
		for (HistoricTaskInstance hi : l1) {
			List<HistoricVariableInstance> l = pe.getHistoryService().createHistoricVariableInstanceQuery().processInstanceId(hi.getProcessInstanceId()).list();
			Map<String, Object> m = new HashMap<String, Object>();
			for (HistoricVariableInstance h : l) {
				m.put(h.getVariableName(), h.getValue());
			
				
			}
			if(m.get("userId").equals(name))l2.add(m);
		}
		if(l2.size()==0)return null;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("t", l1);
		map.put("v", l2);
		return map;
	}

	
}
