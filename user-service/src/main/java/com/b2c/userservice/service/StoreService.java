package com.b2c.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b2c.userservice.model.Store;
import com.b2c.userservice.persist.IStoreDao;

import lombok.Data;

@Data
@Service
public class StoreService {
	@Autowired
	private IStoreDao iStoreDao;

	public long insertStoreData(Store store) {
		return iStoreDao.saveStore(store);
	}

	public Store getStoreData(long id) {
		return iStoreDao.getStoreRseResult(id);
	}

	public Store updateStoreData(long id, String storename, String storelicno, String storepanno,
			String storelicenseimage, String storeaddress, String storecity, String storepincode, float storelat,
			float storelong, String storepicimagename, String storecontactdetails, String ownername,
			String ownercontact, String owneremail, String storetype, String storestate, int createdby) {
		return iStoreDao.updateStoreResult1(id, storename, storelicno, storepanno, storelicenseimage, storeaddress,
				storecity, storepincode, storelat, storelong, storepicimagename, storecontactdetails, ownername,
				ownercontact, owneremail, storetype, storestate, createdby);

	}

	public Store deleteStoreData(long id) {
		return iStoreDao.deleteStoreResult2(id);

	}

}
