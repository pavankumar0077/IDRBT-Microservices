package com.idrbt.lab.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.idrbt.lab.dto.Mobile;

public interface MobileRepository extends MongoRepository<Mobile, Integer>{

}
