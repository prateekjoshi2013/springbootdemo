package com.dailycodebuffer.Springboot.tutorial.service;

import com.dailycodebuffer.Springboot.tutorial.entity.Department;
import com.dailycodebuffer.Springboot.tutorial.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> fetchDepartmentList();

    Department fetchDepartmentById(Long id) throws DepartmentNotFoundException;

    void deleteDepartmentById(Long id);

    Department updateDepartment(Long id, Department department);

    Department fetchDepartmentByName(String name);
}
