package com.idrbt.lab.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idrbt.lab.dto.Mobile;
import com.idrbt.lab.exception.ResourceNotFoundException;
import com.idrbt.lab.repository.MobileRepository;

@Service
public class MobileServiceImpl implements MobileService {

	@Autowired
	MobileRepository mobileRepository;

	@Override
	public Mobile createNewMobile(Mobile mobile) {
		return mobileRepository.save(mobile);
	}	

	@Override
	public Mobile updateMobile(Mobile mobile) {
		Optional<Mobile> mobileDb = this.mobileRepository.findById(mobile.getId());

		if (mobileDb.isPresent()) {
			Mobile mobileUpdate = mobileDb.get();
			mobileUpdate.setId(mobile.getId());
			mobileUpdate.setName(mobile.getName());
			mobileUpdate.setTxn_status(mobile.getTxn_status());
			mobileUpdate.setMessage(mobile.getMessage());
			return mobileUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + mobile.getId());
		}
	}

	@Override
	public List<Mobile> getAllProduct() {
		return this.mobileRepository.findAll();
	}

	@Override
	public Mobile getProductById(int mobileId) {
		Optional<Mobile> mobileDb = this.mobileRepository.findById(mobileId);

		if (mobileDb.isPresent()) {
			return mobileDb.get();
		} else {
			throw new ResourceNotFoundException("Record not found with id " + mobileId);
		}
	}

	@Override
	public void deleteMobileId(int mobileId) {
		Optional<Mobile> mobileDb = this.mobileRepository.findById(mobileId);
		if (mobileDb.isPresent()) {
			this.mobileRepository.delete(mobileDb.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id " + mobileId);
		}

	}

}
