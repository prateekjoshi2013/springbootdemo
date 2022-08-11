package com.dailycodebuffer.Springboot.tutorial.service;

import com.dailycodebuffer.Springboot.tutorial.entity.Department;
import com.dailycodebuffer.Springboot.tutorial.error.DepartmentNotFoundException;
import com.dailycodebuffer.Springboot.tutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long id) throws DepartmentNotFoundException {
        try{
            return departmentRepository.findById(id).get();
        }catch(NoSuchElementException exception){
            throw new DepartmentNotFoundException("Department Not Available");
        }
    }

    @Override
    public void deleteDepartmentById(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department updateDepartment(Long id, Department department) {
        Department departmentFound = departmentRepository.findById(id).orElse(null);
        if (departmentFound == null) {
            return null;
        } else {
            if (department.getAddress() != null) {
                departmentFound.setAddress(department.getAddress());
            }
            if (department.getCode() != null) {
                departmentFound.setCode(department.getCode());
            }
            if (department.getName() != null) {
                departmentFound.setName(department.getName());
            }
            return departmentRepository.save(departmentFound);
        }

    }

    @Override
    public Department fetchDepartmentByName(String name) {
        return departmentRepository.findByNameIgnoreCase(name);
    }


}
