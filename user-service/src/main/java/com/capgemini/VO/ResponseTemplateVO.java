package com.capgemini.VO;

import com.capgemini.entity.EmployeeManagement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {

	private EmployeeManagement user;
	private Department department;
	
	public EmployeeManagement getUser() {
		return user;
	}
	public void setUser(EmployeeManagement user) {
		this.user = user;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
}
