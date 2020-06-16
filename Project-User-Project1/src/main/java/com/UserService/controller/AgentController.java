package com.UserService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.UserService.model.Agent;
import com.UserService.service.AgentService;

@RestController
@RequestMapping("/v1/")
public class AgentController {

	@Autowired
	private AgentService agentService;

	// insert the data
	@RequestMapping(value = "agent", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> insert(@RequestBody Agent request) {
		Agent agent = new Agent(request.getName(), request.getPhonenumber());
		Integer result = agentService.insertData(agent);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	// get the data by id
	@GetMapping("getagent/{id}")
	public ResponseEntity<Agent> invoke3(@PathVariable int id) {
		Agent value = agentService.getAgent(id);
		return new ResponseEntity<>(value, HttpStatus.OK);
	}

	// update the data
	@RequestMapping(path = "updateagent/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Agent> update(@PathVariable int id, @RequestBody Agent request) {
		Agent value = agentService.updateAgent(id, request.getPhonenumber());
		return new ResponseEntity<>(value, HttpStatus.OK);
	}

	// delete the data
	@DeleteMapping(path = "deactivateagent/{id}")
	public ResponseEntity<Agent> delete(@PathVariable int id) {
		Agent value = agentService.deleteAgent(id);
		return new ResponseEntity<>(value, HttpStatus.OK);
	}
}
