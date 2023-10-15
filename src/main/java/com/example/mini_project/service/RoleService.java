package com.example.mini_project.service;

import com.example.mini_project.entity.Role;

import java.util.List;

public interface RoleService {
    public List<Role> findAll();
    public Role findByName(String name);
    public <S extends Role> S save(S entity);
}
