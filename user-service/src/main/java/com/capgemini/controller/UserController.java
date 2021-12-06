package com.capgemini.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.UserServiceApplication;
import com.capgemini.VO.ResponseTemplateVO;
import com.capgemini.entity.EmployeeManagement;
import com.capgemini.exeception.DuplicateEmployeeException;
import com.capgemini.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/employees")
@Slf4j
public class UserController {

	@Autowired
	private UserService userService;
	
	Logger log = LoggerFactory.getLogger(UserServiceApplication.class);
	
	@PostMapping("/")
	public EmployeeManagement saveUser(@Valid @RequestBody EmployeeManagement user) throws DuplicateEmployeeException {
		log.info("Inside saveUser of UserController");
		String tempEmailId = user.getEmail();
		EmployeeManagement emp = null;
		if(tempEmailId != null && !"".equals(tempEmailId)) {
			EmployeeManagement cus1 = userService.getUserByEmail(tempEmailId);
			if(cus1 != null)
			{
				throw new DuplicateEmployeeException("Employee with "+tempEmailId+" is already exists");
			}
		}
		emp = userService.saveUser(user);
		return emp;
	}
	
	@GetMapping("/{id}")
	public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId) {
		log.info("Inside getUserWithDepartment of UserController");
		return userService.getUserWithDepartment(userId);
		 
	}
	
}
