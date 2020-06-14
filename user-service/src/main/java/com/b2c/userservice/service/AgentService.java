package com.b2c.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b2c.userservice.model.Agent;
import com.b2c.userservice.persist.IAgentDao;

import lombok.Data;

@Data
@Service
public class AgentService {
	@Autowired
	private IAgentDao iAgentDao;
	
	public int insertAgentData(Agent agent) {
		return iAgentDao.saveAgent(agent);
	}
	
	public Agent getAgentData(int id) {
		return iAgentDao.getAgentRseResult(id);
	}
	
	public Agent updateAgentData(int id, String phonenumber) {
		return iAgentDao.updateAgentResult1(id, phonenumber);
			
	}
	
	public Agent deleteAgentData(int id) {
		return iAgentDao.deleteAgentResult2(id);
			
	}

}
