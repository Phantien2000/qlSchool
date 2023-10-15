package com.example.mini_project.service;

import com.example.mini_project.entity.Department;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    public Department findByName(String name);
    public List<Department> findAll();
    public <S extends Department> S save (S entity);
    public Optional<Department> findById(Long id);
    public void deleteById(Long id);
    public Page<Department> lisByPage(int pageNum, String sortField, String sortDir);

}
