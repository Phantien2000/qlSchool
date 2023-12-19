package com.example.mini_project.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "awardCertificates")
public class AwardCertificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long level;
    private String name;
    private String description;
    private String date;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "typeAwardCertificate_id")
    private TypeAwardCertificate typeAwardCertificate;

}
