package com.example.mini_project.service;

import com.example.mini_project.Dto.TypeAwardCertificateDto;
import com.example.mini_project.entity.TypeAwardCertificate;

import java.util.List;

public interface TypeAwardCertificateService {
    TypeAwardCertificateDto addTypeAwardCertificate(TypeAwardCertificateDto typeAwardCertificateDto);
    TypeAwardCertificateDto getTypeAwardCertificateById(Long id);
    List<TypeAwardCertificate> getAllTypeAward();
    List<TypeAwardCertificate> getAllTypeCertificate();
  //  void deleteTypeAwardCertificate(Long id);
    TypeAwardCertificateDto editTypeAwardCertificate(Long id,TypeAwardCertificateDto typeAwardCertificateDto );
}
