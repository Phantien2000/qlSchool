package com.example.mini_project.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "typeAward_certificate")
public class TypeAwardCertificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int type; // is award or certificate( 0 is award , 1 is certificate)
    private String name;
    private String description;

    @OneToMany(mappedBy = "typeAwardCertificate", cascade = CascadeType.ALL)
    private Set<AwardCertificate> awardCertificate;
}
