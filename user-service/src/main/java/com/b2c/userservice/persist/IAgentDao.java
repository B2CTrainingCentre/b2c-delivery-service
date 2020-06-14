package com.b2c.userservice.persist;

import com.b2c.userservice.model.Agent;

public interface IAgentDao {
	public int saveAgent(Agent agent);
	public Agent getAgentRseResult(int id);
	public Agent updateAgentResult1(int id, String phonenumber);
	public Agent deleteAgentResult2(int id);


}
