package com.example.mini_project.repository;

import com.example.mini_project.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByEmail(String email);

    Page<User> findByDepartmentId(Integer departmentId, Pageable pageable);
}
