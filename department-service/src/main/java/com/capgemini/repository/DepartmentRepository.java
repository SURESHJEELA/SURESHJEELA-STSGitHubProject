package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

	@Query("SELECT dd from Department dd where dd.departmentId=?1")
	public Department findDepartmentById(Long departmentId);

}
