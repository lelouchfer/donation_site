package com.teslus.donation.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

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

  
}