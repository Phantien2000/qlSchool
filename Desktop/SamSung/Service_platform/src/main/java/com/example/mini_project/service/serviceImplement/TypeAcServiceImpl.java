package com.example.mini_project.service.serviceImplement;

import com.example.mini_project.Dto.TypeAwardCertificateDto;
import com.example.mini_project.entity.TypeAwardCertificate;
import com.example.mini_project.repository.TypeAwardCertificateRepository;
import com.example.mini_project.service.TypeAwardCertificateService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;

@Service

public class TypeAwardCertificateServiceImpl implements TypeAwardCertificateService {
    private TypeAwardCertificateRepository typeAwardCertificateRepo;
    private ModelMapper modelMapper;
    @Autowired
    public TypeAwardCertificateDto addTypeAwardCertificate(TypeAwardCertificateDto typeAwardCertificateDto){
          TypeAwardCertificate exitType = typeAwardCertificateRepo.findByName(typeAwardCertificateDto.getName());
          if(exitType != null){
              throw new IllegalStateException("Name is alredly ");
          }else {
              typeAwardCertificateRepo.save(modelMapper.map(typeAwardCertificateDto,TypeAwardCertificate.class));
              return typeAwardCertificateDto;
          }
    }
    TypeAwardCertificateDto getTypeAwardCertificateById(Long id){
        Optional<TypeAwardCertificate> typeAwardCertificate = typeAwardCertificateRepo.findById(id);
        if(typeAwardCertificate.isPresent()){
            return modelMapper.map(typeAwardCertificate.get(), TypeAwardCertificateDto.class);
        }
        else {
            
        }
    }
    List<TypeAwardCertificate> getAllTypeAward();
    List<TypeAwardCertificate> getAllTypeCertificate();
    //  void deleteTypeAwardCertificate(Long id);
    TypeAwardCertificateDto editTypeAwardCertificate(Long id,TypeAwardCertificateDto typeAwardCertificateDto );
}
