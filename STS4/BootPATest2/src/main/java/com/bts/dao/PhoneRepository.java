package com.bts.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bts.dto.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Integer> {

	
}
