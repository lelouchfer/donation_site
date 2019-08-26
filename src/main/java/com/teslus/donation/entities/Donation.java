package com.teslus.donation.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "donation")
@Entity
@Data
public class Donation implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_donation", insertable = false, nullable = false)
  private Integer idDonation;

  @Column(name = "id_donator")
  private Integer idDonator;

  @Column(name = "id_institution")
  private Integer idInstitution;

  @Column(name = "ammount")
  private BigDecimal ammount;

  @Column(name = "fecha")
  private Date fecha;

  @Column(name = "cc_number")
  private String number;



  @ManyToOne
  @JoinColumn(name = "id_donator", referencedColumnName = "id_donator", insertable = false, updatable = false)
  public Donator donator;


  @ManyToOne
  @JoinColumn(name = "id_institution", referencedColumnName = "id_institution",  insertable = false, updatable = false)
  public Institution institution;
}