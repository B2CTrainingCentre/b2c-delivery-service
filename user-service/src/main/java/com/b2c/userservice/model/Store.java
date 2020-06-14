package com.b2c.userservice.model;

import java.sql.Timestamp;

public class Store {
	private long id;
	private String storename;
	private String storelicno;
	private String storepanno;
	private String storelicenseimage;
	private String storeaddress;
	private String storecity;
	private String storepincode;
	private float storelat;
	private float storelong;
	private String storepicimagename;
	private String storecontactdetails;
	private String ownername;
	private String ownercontact;
	private String owneremail;
	private String status;
	private String storetype;
	private String storestate;
	private int createdby;
	private Timestamp createddate;
	public Store(long id, String storename, String storelicno, String storepanno, String storelicenseimage,
			String storeaddress, String storecity, String storepincode, float storelat, float storelong,
			String storepicimagename, String storecontactdetails, String ownername, String ownercontact,
			String owneremail, String status, String storetype, String storestate, int createdby,
			Timestamp createddate) {
		super();
		this.id = id;
		this.storename = storename;
		this.storelicno = storelicno;
		this.storepanno = storepanno;
		this.storelicenseimage = storelicenseimage;
		this.storeaddress = storeaddress;
		this.storecity = storecity;
		this.storepincode = storepincode;
		this.storelat = storelat;
		this.storelong = storelong;
		this.storepicimagename = storepicimagename;
		this.storecontactdetails = storecontactdetails;
		this.ownername = ownername;
		this.ownercontact = ownercontact;
		this.owneremail = owneremail;
		this.status = status;
		this.storetype = storetype;
		this.storestate = storestate;
		this.createdby = createdby;
		this.createddate = createddate;
	}
	public Store(String storename, String storelicno, String storepanno, String storelicenseimage, String storeaddress,
			String storecity, String storepincode, float storelat, float storelong, String storepicimagename,
			String storecontactdetails, String ownername, String ownercontact, String owneremail, String storetype,
			String storestate, int createdby) {
		super();
		this.storename = storename;
		this.storelicno = storelicno;
		this.storepanno = storepanno;
		this.storelicenseimage = storelicenseimage;
		this.storeaddress = storeaddress;
		this.storecity = storecity;
		this.storepincode = storepincode;
		this.storelat = storelat;
		this.storelong = storelong;
		this.storepicimagename = storepicimagename;
		this.storecontactdetails = storecontactdetails;
		this.ownername = ownername;
		this.ownercontact = ownercontact;
		this.owneremail = owneremail;
		this.storetype = storetype;
		this.storestate = storestate;
		this.createdby = createdby;
	}
	public Store() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStorename() {
		return storename;
	}
	public void setStorename(String storename) {
		this.storename = storename;
	}
	public String getStorelicno() {
		return storelicno;
	}
	public void setStorelicno(String storelicno) {
		this.storelicno = storelicno;
	}
	public String getStorepanno() {
		return storepanno;
	}
	public void setStorepanno(String storepanno) {
		this.storepanno = storepanno;
	}
	public String getStorelicenseimage() {
		return storelicenseimage;
	}
	public void setStorelicenseimage(String storelicenseimage) {
		this.storelicenseimage = storelicenseimage;
	}
	public String getStoreaddress() {
		return storeaddress;
	}
	public void setStoreaddress(String storeaddress) {
		this.storeaddress = storeaddress;
	}
	public String getStorecity() {
		return storecity;
	}
	public void setStorecity(String storecity) {
		this.storecity = storecity;
	}
	public String getStorepincode() {
		return storepincode;
	}
	public void setStorepincode(String storepincode) {
		this.storepincode = storepincode;
	}
	public float getStorelat() {
		return storelat;
	}
	public void setStorelat(float storelat) {
		this.storelat = storelat;
	}
	public float getStorelong() {
		return storelong;
	}
	public void setStorelong(float storelong) {
		this.storelong = storelong;
	}
	public String getStorepicimagename() {
		return storepicimagename;
	}
	public void setStorepicimagename(String storepicimagename) {
		this.storepicimagename = storepicimagename;
	}
	public String getStorecontactdetails() {
		return storecontactdetails;
	}
	public void setStorecontactdetails(String storecontactdetails) {
		this.storecontactdetails = storecontactdetails;
	}
	public String getOwnername() {
		return ownername;
	}
	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}
	public String getOwnercontact() {
		return ownercontact;
	}
	public void setOwnercontact(String ownercontact) {
		this.ownercontact = ownercontact;
	}
	public String getOwneremail() {
		return owneremail;
	}
	public void setOwneremail(String owneremail) {
		this.owneremail = owneremail;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStoretype() {
		return storetype;
	}
	public void setStoretype(String storetype) {
		this.storetype = storetype;
	}
	public String getStorestate() {
		return storestate;
	}
	public void setStorestate(String storestate) {
		this.storestate = storestate;
	}
	public int getCreatedby() {
		return createdby;
	}
	public void setCreatedby(int createdby) {
		this.createdby = createdby;
	}
	public Timestamp getCreateddate() {
		return createddate;
	}
	public void setCreateddate(Timestamp createddate) {
		this.createddate = createddate;
	}
	
	


}
