package com.b2c.userservice.persist;

import com.b2c.userservice.model.Store;

public interface IStoreDao {
	public long saveStore(Store store);
	public Store getStoreRseResult(long id);
	public Store updateStoreResult1(long id, String storename, String storelicno, String storepanno, String storelicenseimage, 
			String storeaddress, String storecity, String storepincode, float storelat, float storelong, String storepicimagename, 
			String storecontactdetails, String ownername, String ownercontact, String owneremail, String storetype, String storestate, 
			int createdby);
	public Store deleteStoreResult2(long id);

}
