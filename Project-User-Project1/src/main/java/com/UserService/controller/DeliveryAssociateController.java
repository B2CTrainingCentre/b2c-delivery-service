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

import com.UserService.model.DeliveryAssociate;
import com.UserService.service.DeliveryAssociateService;

@RestController
@RequestMapping("/v2/")
public class DeliveryAssociateController {

	@Autowired
	private DeliveryAssociateService deliveryAssociateService;

	// insert data
	@RequestMapping(value = "deliveryassociate", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<Integer> insert(@RequestBody DeliveryAssociate request) {
		DeliveryAssociate deliveryAssociate = new DeliveryAssociate(request.getName(), request.getPhonenumber(),
				request.getEmail(), request.getLatitude(), request.getLongitude(), request.getPanno(),
				request.getDaimage());
		Integer result = deliveryAssociateService.insertData(deliveryAssociate);
		return new ResponseEntity<>(result, HttpStatus.OK);

	}

	// get the data by id
	@GetMapping("getdeliveryassociate/{id}")
	public ResponseEntity<DeliveryAssociate> invoke3(@PathVariable int id) {
		DeliveryAssociate value = deliveryAssociateService.getDeliveryAssociate(id);
		return new ResponseEntity<>(value, HttpStatus.OK);
	}

	// update the data
	@RequestMapping(path = "updatedeliveryassociate/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DeliveryAssociate> update(@PathVariable int id, @RequestBody DeliveryAssociate request) {
		DeliveryAssociate value = deliveryAssociateService.updateDeliveryAssociate(id, request.getPhonenumber());
		return new ResponseEntity<>(value, HttpStatus.OK);
	}

	// delete the data
	@DeleteMapping(path = "deactivatedeliveryassociate/{id}")
	public ResponseEntity<DeliveryAssociate> delete(@PathVariable int id) {
		DeliveryAssociate value = deliveryAssociateService.deleteDeliveryAssociate(id);
		return new ResponseEntity<>(value, HttpStatus.OK);
	}

}