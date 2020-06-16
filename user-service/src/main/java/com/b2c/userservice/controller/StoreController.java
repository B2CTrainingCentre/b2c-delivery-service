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

import com.b2c.userservice.model.Store;
import com.b2c.userservice.service.StoreService;

@RestController
@RequestMapping("/v1/")
public class StoreController {
	@Autowired
	private StoreService storeService;

	@RequestMapping(path = "insertstore", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Long> insert(@RequestBody Store request) {
		System.out.println(request.getStorename());
		Store store = new Store(request.getStorename(), request.getStorelicno(), request.getStorepanno(),
				request.getStorelicenseimage(), request.getStoreaddress(), request.getStorecity(),
				request.getStorepincode(), request.getStorelat(), request.getStorelong(),
				request.getStorepicimagename(), request.getStorecontactdetails(), request.getOwnername(),
				request.getOwnercontact(), request.getOwneremail(), request.getStoretype(), request.getStorestate(),
				request.getCreatedby());
		// List<Store> list = storeService.insertData();
		Long value = storeService.insertStoreData(store);
		if (value != 0) {
			return new ResponseEntity<>(value, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(value, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("fetchstore/{id}")
	public ResponseEntity<Store> fetch(@PathVariable long id) {
		Store value = storeService.getStoreData(id);
		return new ResponseEntity<>(value, HttpStatus.OK);
	}

	// update record into database with input from postman
	@RequestMapping(path = "updatestore/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Store> update(@PathVariable long id, @RequestBody Store request) {
		Store value = storeService.updateStoreData(id, request.getStorename(), request.getStorelicno(),
				request.getStorepanno(), request.getStorelicenseimage(), request.getStoreaddress(),
				request.getStorecity(), request.getStorepincode(), request.getStorelat(), request.getStorelong(),
				request.getStorepicimagename(), request.getStorecontactdetails(), request.getOwnername(),
				request.getOwnercontact(), request.getOwneremail(), request.getStoretype(), request.getStorestate(),
				request.getCreatedby());
		if (value != null) {
			return new ResponseEntity<>(value, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(value, HttpStatus.NOT_FOUND);
		}
		//return new ResponseEntity<>(value, HttpStatus.OK); code commented
	}

	// deactivate record in database
	@DeleteMapping(path = "deactivestore/{id}")
	public ResponseEntity<Store> delete(@PathVariable long id) {
		Store value = storeService.deleteStoreData(id);
		return new ResponseEntity<>(value, HttpStatus.OK);
	}

}
