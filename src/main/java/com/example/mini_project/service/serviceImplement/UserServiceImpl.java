package com.example.mini_project.service.serviceImplement;

import com.example.mini_project.entity.User;
import com.example.mini_project.repository.UserRepository;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.nio.file.ProviderNotFoundException;
import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl {
    int USER_PER_PAGE =3;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    public List<User> findAll(){
        return userRepository.findAll();

    }
//    public Page<User> listByPage(int pageNum, String sortField,  String sortDir, Integer departmentId){
//        Sort sort = Sort.by(sortField);
//        sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
//        Pageable pageable = PageRequest.of(pageNum -1 , USER_PER_PAGE, sort);
//        if(departmentId == null || departmentId == 0){
//            return userRepository.findAll(pageable);
//        }
//        return userRepository.findByDepartmentId(departmentId, pageable);
//    }
    public <S extends User> S save(S entity){

        String encoder = passwordEncoder.encode(entity.getPassword());
        entity.setPassword(encoder);
        return userRepository.save(entity);

    }

    public Optional<User> findById(Long id){
        Optional<User> user = userRepository.findById(id);
        return user;
    }
    public void deleteById(Long id){
        userRepository.deleteById(id);
    }

}
