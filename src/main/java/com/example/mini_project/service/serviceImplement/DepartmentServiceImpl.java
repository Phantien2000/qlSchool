package com.example.mini_project.service.serviceImplement;

import com.example.mini_project.entity.Department;
import com.example.mini_project.repository.DepartmentRepository;
import com.example.mini_project.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DepartmentServiceImpl implements DepartmentService {
    int DEPARTMENT_PER_PAGE = 3;
    @Autowired
    DepartmentRepository departmentRepository;
    public Department findByName(String name){
        return departmentRepository.findByName(name);
    }
    public List<Department> findAll(){
        return departmentRepository.findAll();
    }
    public <S extends Department> S save (S entity){
        return departmentRepository.save(entity);
    }
    public Optional<Department> findById(Long id){
        return departmentRepository.findById(id);
    }
    public void deleteById(Long id){
        departmentRepository.deleteById(id);
    }
    public Page<Department> lisByPage(int pageNum, String sortField, String sortDir){
        Sort sort = Sort.by(sortField);
        sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
        Pageable pageable = PageRequest.of(pageNum -1 , DEPARTMENT_PER_PAGE, sort);
        return departmentRepository.findAll(pageable);
    }
}
