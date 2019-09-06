package com.cpe.backend.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.FetchType;


import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



import javax.persistence.Column;
import javax.persistence.Entity;


@Entity  
@Data  
@NoArgsConstructor  
@Table(name = "PATIENT")
public class Patient {  //ผู้ป่วย
      
  @Id 
  @SequenceGenerator(name="patient_seq",sequenceName="patient_seq")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="patient_seq") 
  @Column(name = "Patinet_ID", unique = true, nullable = true)
  private @NonNull Long id;  

  @Column(name = "NATIONAL_ID", unique = true, nullable = true)
  private  Long nationalID;  


  private String name = "";


  private String Address = "";



  private String initialSsym = "";
  
  private int hight ;
  private int weigth ;
  
  @ManyToOne(fetch = FetchType.EAGER, targetEntity = Benefit.class)
  @JoinColumn(name = "BENEFIT_ID", insertable = true)
  private Benefit benefit ;

  @ManyToOne(fetch = FetchType.EAGER, targetEntity = Province.class)
  @JoinColumn(name = "PROVINCE_ID", insertable = true)
  private Province province ;

  @ManyToOne(fetch = FetchType.EAGER, targetEntity = Gender.class)
  @JoinColumn(name = "GENDER_ID", insertable = true)
  private Gender gender;


  //benefit
  //Province
  //Gender




      
}