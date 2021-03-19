package com.task.taskuniversity.service;

import com.task.taskuniversity.model.Department;
import com.task.taskuniversity.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> searchByNameLike(String word) {
        List<Department> departments = departmentRepository.searchByNameLike(word);

        return departments;
    }

    public Department findByName(String name) {
        return departmentRepository.findByName(name);
    }
}
