package com.UserService.persist;

import com.UserService.model.DeliveryAssociate;

public interface IDeliveryAssociateDao {

	public int save(DeliveryAssociate deliveryassociate);

	public DeliveryAssociate getRseResult(int id);
	
	public DeliveryAssociate getResult1(int id, String phonenumber);
	
	public DeliveryAssociate getResult2(int id);

}
