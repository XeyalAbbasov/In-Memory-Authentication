package com.khayal.springsecurity.repo;

import com.khayal.springsecurity.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone,Integer> {
}
