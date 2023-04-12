package com.idrbt.lab.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idrbt.lab.dto.Mobile;
import com.idrbt.lab.repository.MobileRepository;



@Service
public class MobileServiceImpl implements MobileService	{

	@Autowired
	MobileRepository mobileRepository;
	
	

	@Override
	public Mobile createNewMobile(Mobile mobile) {
		return mobileRepository.save(mobile);
	}
	
	
//	@Override
//	public Product updateProduct(Product product) {
//		Optional<Product> productDb = this.productRepository.findById(product.getId());
//
//		if (productDb.isPresent()) {
//			Product productUpdate = productDb.get();
//			productUpdate.setId(product.getId());
//			productUpdate.setName(product.getName());
//			productUpdate.setDescription(product.getDescription());
//			productRepository.save(productUpdate);
//			return productUpdate;
//		} else {
//			throw new ResourceNotFoundException("Record not found with id : " + product.getId());
//		}
//	}

	@Override
	public Mobile updateMobile(Mobile mobile) {
		Optional<Mobile> mobileDb = this.mobileRepository.findById(mobile.getId());
		
		if(mobileDb.isPresent()) {
			Mobile mobileUpdate = mobileDb.get();
			mobileUpdate.setId(mobile.getId());
			
			
			
		}
		return null;
	}

	@Override
	public List<Mobile> getAllProduct() {
		return this.mobileRepository.findAll();
	}
	

	@Override
	public Mobile getProductById(int mobileId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteMobileId1(int mobileId) {
		// TODO Auto-generated method stub
		
	}
	
	

}
