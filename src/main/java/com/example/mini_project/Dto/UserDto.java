package com.example.mini_project.Dto;

import com.example.mini_project.entity.Department;

import java.util.Set;

public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String Email;
    private Set<String> roles;
    private Department department;

    public UserDto(String firstName, String lastName, String email, Set<String> roles, Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        Email = email;
        this.roles = roles;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public UserDto(){}

}
