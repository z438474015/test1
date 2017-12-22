package com.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricVariableInstance;
import org.activiti.engine.repository.Deployment;
import org.junit.Test;

public class Util {
	
	private ProcessEngine pe = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml").buildProcessEngine();
	
	
	public static String getUUID(){
		return UUID.randomUUID().toString().trim().replace("-", "");
	}
	
	
//	@Test
//	public void deploy(){
//		Deployment deployment = pe.getRepositoryService()
//								.createDeployment()
//								.addClasspathResource("leave.bpmn")
//								.addClasspathResource("leave.png")
//								.deploy();
//		System.out.println(deployment.getId());
//		System.out.println(deployment.getName());
//		System.out.println("流程已发布，一个流程只需发布一次即可");
//	}
	
	@Test
	public void plan(){
		List<HistoricTaskInstance> list = pe.getHistoryService().createHistoricTaskInstanceQuery().taskAssignee("小张").list();
		for (HistoricTaskInstance hi : list) {
			System.out.println("任务人:"+hi.getAssignee()+hi.getTaskDefinitionKey()
								+" 执行ID："+hi.getExecutionId()+hi.getProcessDefinitionId()
								+" 办理实例ID："+hi.getProcessInstanceId()
								+" 执行步骤名称："+hi.getName()
								+" 任务ID："+hi.getId()
								+" 发起时间："+hi.getStartTime());
			List<HistoricVariableInstance> var = pe.getHistoryService().createHistoricVariableInstanceQuery().processInstanceId(hi.getProcessInstanceId()).list();
			Map<String, Object> map = new HashMap<String, Object>();
			for (HistoricVariableInstance h : var) {
				map.put(h.getProcessInstanceId()+h.getVariableName(), h.getValue());
				System.out.println(h.getId()+" "+h.getProcessInstanceId()+" "+h.getVariableName()+" "+h.getValue());
			}
			System.out.println(map);
		}
		//同时看看流程里的参数信息
		
	} 
}
