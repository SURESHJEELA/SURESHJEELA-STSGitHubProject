package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.entity.EmployeeManagement;

@Repository
public interface UserRepository extends JpaRepository<EmployeeManagement, Long>{

	public EmployeeManagement findByUserId(Long userId);

	public EmployeeManagement findUserByEmail(String email);


}
