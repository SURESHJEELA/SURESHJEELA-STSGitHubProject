package com.capgemini.service;

import com.capgemini.VO.ResponseTemplateVO;
import com.capgemini.entity.EmployeeManagement;
import com.capgemini.exeception.NoSuchDepartmentException;
import com.capgemini.exeception.NoSuchEmployeeException;

public interface UserService {

	public EmployeeManagement saveUser(EmployeeManagement user) throws NoSuchDepartmentException;

	public ResponseTemplateVO getUserWithDepartment(Long userId) throws NoSuchEmployeeException;
	
	public EmployeeManagement getUserByEmail(String email);
	

}
