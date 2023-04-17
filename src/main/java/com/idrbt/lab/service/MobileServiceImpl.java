package com.idrbt.lab.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.idrbt.lab.dto.Mobile;
import com.idrbt.lab.exception.ResourceNotFoundException;
import com.idrbt.lab.repository.MobileRepository;

@Service
public class MobileServiceImpl implements MobileService {

	Mobile mobile;

	@Autowired
	MobileRepository mobileRepository;

	@Autowired
	private RedisTemplate redisTemplate;

	private static final String KEY = "MOBILE";

	final Logger logger = LoggerFactory.getLogger(MobileServiceImpl.class);

	@Override
	public Mobile createNewMobile(Mobile mobile) {
		logger.info("New mobile details implementation");
		return mobileRepository.save(mobile);
	}

	@Override
	public Mobile updateMobile(Mobile mobile) {
		logger.info("Update mobile details service implementation");
		Optional<Mobile> mobileDb = this.mobileRepository.findById(mobile.getId());

		if (mobileDb.isPresent()) {
			Mobile mobileUpdate = mobileDb.get();
			mobileUpdate.setId(mobile.getId());
			mobileUpdate.setAmount(mobile.getAmount());
			mobileUpdate.setAccount(mobile.getAccount());
			mobileUpdate.setTxn_status(mobile.getTxn_status());
			mobileUpdate.setMessage(mobile.getMessage());
			return mobileUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + mobile.getId());
		}
	}

	@Override
	public List<Mobile> getAllProduct() {
		logger.info("Mobile service implementation to get all the mobile details");
		return this.mobileRepository.findAll();

	}

	@Override
	public Mobile getProductById(int mobileId) {
		Optional<Mobile> mobileDb = this.mobileRepository.findById(mobileId);
		logger.info("Mobile service implementation to get mobile details for a particular mobile id");

		if (mobileDb.isPresent()) {
			return mobileDb.get();
		} else {
			throw new ResourceNotFoundException("Record not found with id " + mobileId);
		}
	}

	@Override
	public void deleteMobileId(int mobileId) {
		logger.info("Mobile service implementation to delete mobile details for a particular mobile id");

		Optional<Mobile> mobileDb = this.mobileRepository.findById(mobileId);
		if (mobileDb.isPresent()) {
			this.mobileRepository.delete(mobileDb.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id " + mobileId);
		}

	}

//	Redis cache impl

	@Override
	public List<Mobile> fetchAllMobiles() {
		List<Mobile> mobile;
		mobile = redisTemplate.opsForHash().values(KEY);
		return mobile;
	}

	@Override
	public boolean saveMobile(Mobile mobile) {
		try {
			redisTemplate.opsForHash().put(KEY, mobile.getId(), mobile);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
