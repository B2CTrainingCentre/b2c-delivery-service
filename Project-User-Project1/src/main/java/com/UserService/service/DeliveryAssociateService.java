package com.UserService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UserService.model.DeliveryAssociate;
import com.UserService.persist.IDeliveryAssociateDao;

@Service
public class DeliveryAssociateService {

	@Autowired
	private IDeliveryAssociateDao iDeliveryAssociateDao;

	// insert data
	public int insertData(DeliveryAssociate deliveryassociate) {
		return iDeliveryAssociateDao.save(deliveryassociate);
	}

	// get the data by id
	public DeliveryAssociate getDeliveryAssociate(int id) {
		return iDeliveryAssociateDao.getRseResult(id);
	}

	// update the data
	public DeliveryAssociate updateDeliveryAssociate(int id, String phonenumber) {
		return iDeliveryAssociateDao.getResult1(id, phonenumber);
	}

	// delete the data
	public DeliveryAssociate deleteDeliveryAssociate(int id) {
		return iDeliveryAssociateDao.getResult2(id);
	}
}
