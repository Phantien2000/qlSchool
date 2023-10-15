package com.example.mini_project.controller;

import com.example.mini_project.Dto.UserDto;
import com.example.mini_project.entity.Role;
import com.example.mini_project.entity.User;
import com.example.mini_project.repository.UserRepository;
import com.example.mini_project.service.serviceImplement.UserServiceImpl;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")

public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/getById/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.findById(id);
        if(user.isPresent()){
            UserDto userDto = convertToDto(user.get());
            return ResponseEntity.status(HttpStatus.OK).body(
                    userDto
            );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserDto>> getAllUsers() {
          List<User> users = userService.findAll();
          List<UserDto> userDto = convertToDtoList(users);
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/add")
    public ResponseEntity<User> createUser(@RequestBody User newUser) {
        //2 user must not have the same email !
        List<User> foundUser = userRepository.findByEmail(newUser.getEmail().trim());
        if(foundUser.size() > 0) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                userRepository.save(newUser));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        Optional<User> exitUser = userService.findById(id);
        if(exitUser.isPresent()){
            User user = exitUser.get();
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            user.setEmail(userDto.getEmail());
            user.setDepartment(userDto.getDepartment());
            return ResponseEntity.status(HttpStatus.OK).body(
                    userRepository.save(user));
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        Optional<User> exitUser = userService.findById(id);
        if(exitUser.isPresent()){
            userService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @GetMapping
    public List<User> listByPage(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize,
                                 @RequestParam("sortField") String sortField,
                                 @RequestParam("sortOrder") String sortOrder,
                                 @RequestParam(value = "departmentId", required = false) Integer departmentId) {
        Pageable pageable = PageRequest.of(page, pageSize, getSortDirection(sortOrder), sortField);
        Page<User> userPage;
        if (departmentId != null) {
            userPage = userRepository.findByDepartmentId(departmentId, pageable);
        } else {
            userPage = userRepository.findAll(pageable);
        }
        return userPage.getContent();
    }
    private UserDto convertToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setRoles(user.getRoles().stream()
                .map(Role::getName)
                .collect(Collectors.toSet()));
        userDto.setDepartment(user.getDepartment());
        return userDto;
    }

    private List<UserDto> convertToDtoList(List<User> users) {
        List<UserDto> userDtoList = new ArrayList<>();
        for(User user : users){
            UserDto userDto = convertToDto(user);
            userDtoList.add(userDto);
        }
        return userDtoList;
    }

    private Sort.Direction getSortDirection(String sortOrder) {
        if ("asc".equalsIgnoreCase(sortOrder)) {
            return Sort.Direction.ASC;
        } else if ("desc".equalsIgnoreCase(sortOrder)) {
            return Sort.Direction.DESC;
        }
        throw new IllegalArgumentException("Invalid sort order: " + sortOrder);
    }

}