package com.b2c.userservice.controller;

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

import com.b2c.userservice.model.Agent;
import com.b2c.userservice.service.AgentService;

@RestController
@RequestMapping("/v1/")
public class AgentController {
	@Autowired
	private AgentService agentService;

	@RequestMapping(path = "insertagent", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> insert(@RequestBody Agent request) {
		System.out.println(request.getPhonenumber());
		Agent agent = new Agent(request.getName(), request.getPhonenumber());
		// List<Customer> list = customerService.insertData();
		Integer value = agentService.insertAgentData(agent);
		return new ResponseEntity<>(value, HttpStatus.OK);
	}

	@GetMapping("fetchagent/{id}")
	public ResponseEntity<Agent> fetch(@PathVariable int id) {
		Agent value = agentService.getAgentData(id);
		return new ResponseEntity<>(value, HttpStatus.OK);
	}

	// update record into database with input from postman
	@RequestMapping(path = "updateagent/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Agent> update(@PathVariable int id, @RequestBody Agent request) {
		Agent value = agentService.updateAgentData(id, request.getPhonenumber());
		return new ResponseEntity<>(value, HttpStatus.OK);
	}

	// deactivate record in database
	@DeleteMapping(path = "deactiveagent/{id}")
	public ResponseEntity<Agent> delete(@PathVariable int id) {
		Agent value = agentService.deleteAgentData(id);
		return new ResponseEntity<>(value, HttpStatus.OK);
	}

}
