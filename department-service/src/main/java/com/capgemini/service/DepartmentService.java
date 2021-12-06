package com.capgemini.service;

import com.capgemini.entity.Department;

public interface DepartmentService {

	public Department saveDepartment(Department department);

	public Department findDepartmentById(Long departmentId);

}
