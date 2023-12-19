package com.example.mini_project.repository;

import com.example.mini_project.entity.TypeAwardCertificate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeAwardCertificateRepository extends JpaRepository<TypeAwardCertificate, Long> {
    TypeAwardCertificate findByName(String name);
}
