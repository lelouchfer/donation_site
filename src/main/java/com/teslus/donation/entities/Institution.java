package com.teslus.donation.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "institution")
@Data
@Entity
public class Institution implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_institution", insertable = false, nullable = false)
  private Integer idInstitution;

  @Column(name = "name")
  private String name;

  @Column(name = "id_country")
  private Integer idCountry;

  @ManyToOne
  @JoinColumn(name = "id_country", referencedColumnName = "id_country",  insertable = false, updatable = false)
  public Country country;

}