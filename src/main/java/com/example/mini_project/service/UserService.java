package com.example.mini_project.service;

import com.example.mini_project.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public List<User> findAll();
    public Page<User> listByPage(int pageNum, String sortField, String sortDir, Integer departmentId);
    public <S extends User> S save(S entity);
    public Optional<User> findById(Long id);
    public void deleteById(Long id);
//    public User findByEmail(String email);
}
