package com.teslus.donation.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "donator")
@Data
public class Donator implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_donator", insertable = false, nullable = false)
  private Integer idDonator;

  @Column(name = "id_user")
  private Integer idUser;

  @Column(name = "id_document")
  private Integer idDocument;

  @Column(name = "document_number")
  private String documentNumber;

  @Column(name = "id_country")
  private Integer idCountry;

  @Column(name = "id_department")
  private Integer idDepartment;

  @ManyToOne
  @JoinColumn(name = "id_country", referencedColumnName = "id_country",  insertable = false, updatable = false)
  public Country country;

  @ManyToOne
  @JoinColumn(name = "id_user", referencedColumnName = "id_user",  insertable = false, updatable = false)
  public User user;


}