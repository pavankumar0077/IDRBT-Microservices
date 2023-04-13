package com.idrbt.lab.service;

import java.util.List;

import com.idrbt.lab.dto.Mobile;


public interface MobileService {
	
	public Mobile createNewMobile(Mobile mobile);
	
	public Mobile updateMobile(Mobile mobile);
	
	List<Mobile> getAllProduct();
	
	Mobile getProductById(int mobileId);
	
	void deleteMobileId(int mobileId);
	
	
//	Redis Cache methods
	public List<Mobile> fetchAllMobiles();
	public boolean saveMobile(Mobile mobile);
	
//	public boolean deleteAllMobileDetails();
//	public boolean deleteMobileId(int mobileId);
//	public Mobile updateMobile(int mobileId, Mobile updatedMobile);
//	
//	public Mobile getMobileById(int mobileId);
//	public List<Mobile> getAllMobile();

}
	