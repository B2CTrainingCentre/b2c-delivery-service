package com.UserService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.UserService.model.Agent;
import com.UserService.persist.IAgentDao;

@Component
@Qualifier("agentService")
@Service
public class AgentService {

	@Autowired
	private IAgentDao iAgentDao;

	// insert the data
	public int insertData(Agent agent) {
		return iAgentDao.save(agent);
	}

	// update the data
	public Agent updateAgent(int id, String phonenumber) {
		return iAgentDao.getResult1(id, phonenumber);
	}

	// get the data by id
	public Agent getAgent(int id) {
		return iAgentDao.getRseResult(id);
	}

	// delete the data
	public Agent deleteAgent(int id) {
		return iAgentDao.getResult2(id);
	}

}
