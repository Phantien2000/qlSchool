package com.example.mini_project.service.serviceImplement;

import com.example.mini_project.entity.Role;
import com.example.mini_project.repository.RoleRepository;
import com.example.mini_project.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;
    public List<Role> findAll(){
        return roleRepository.findAll();
    }
    public Role findByName(String name){
        return roleRepository.findByName(name);
    }
    public <S extends Role> S save(S entity){
        return roleRepository.save(entity);
    }


}
