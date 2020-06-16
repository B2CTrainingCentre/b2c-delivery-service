package com.UserService.persist;

import com.UserService.model.Agent;

public interface IAgentDao {

	// insert the data
	public int save(Agent agent);

	// update the data
	public Agent getResult1(int id, String phonenumber);

	// get the data by id
	public Agent getRseResult(int id);

	// delete the data
	public Agent getResult2(int id);
}
