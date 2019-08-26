package com.teslus.donation.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Table(name = "department")
@Entity
public class Department implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(insertable = false, name = "id_department", nullable = false)
  private Integer idDepartment;

  @Column(name = "id_country")
  private Integer idCountry;

  @Column(name = "name")
  private String name;


  @ManyToOne
  @JoinColumn(name = "id_country", referencedColumnName = "id_country",  insertable = false, updatable = false)
  public Country country;
  
}