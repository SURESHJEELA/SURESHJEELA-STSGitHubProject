package com.capgemini.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capgemini.UserServiceApplication;
import com.capgemini.VO.Department;
import com.capgemini.VO.ResponseTemplateVO;
import com.capgemini.entity.EmployeeManagement;
import com.capgemini.exeception.NoSuchDepartmentException;
import com.capgemini.exeception.NoSuchEmployeeException;
import com.capgemini.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	

	Logger log = LoggerFactory.getLogger(UserServiceApplication.class);
	
	@Override
	public EmployeeManagement saveUser(EmployeeManagement user) throws NoSuchDepartmentException{
		log.info("Inside saveUser of UserService");
		ResponseTemplateVO vo = new ResponseTemplateVO();
		Department department = restTemplate.getForObject("http://localhost:9001/departments/"+ user.getDepartmentId(), Department.class);
		if(department == null) {
			throw new NoSuchDepartmentException("No Such Department with "+user.getDepartmentId()+" is not present");
		}
		else {
			return userRepository.save(user);
		}	
	}

	@Override
	public ResponseTemplateVO getUserWithDepartment(Long userId) throws NoSuchEmployeeException{
		log.info("Inside getUserWithDepartment of UserService");
		ResponseTemplateVO vo = new ResponseTemplateVO();
		EmployeeManagement user = userRepository.findByUserId(userId);
		if(user == null) {
			throw new NoSuchEmployeeException("No Such Employee with "+userId+" is not present");
		}
		else {
			
			Department department = restTemplate.getForObject("http://localhost:9001/departments/"+ user.getDepartmentId(), Department.class);
			vo.setUser(user);
			vo.setDepartment(department);
			return vo;
		}
	}

	@Override
	public EmployeeManagement getUserByEmail(String email) {
		
		return userRepository.findUserByEmail(email);
	}

	
}
