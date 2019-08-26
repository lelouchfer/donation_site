package com.teslus.donation.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Table(name = "user")
@Data
@Entity
public class User implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(insertable = false, name = "id_user", nullable = false)
  private Integer idUser;

  @Column(name = "email", nullable = false)
  private String email;

  @Column(name = "first_name", nullable = false)
  private String firstName;

  @Column(name = "last_name", nullable = false)
  private String lastName;

  @Column(name = "password", nullable = false)
  private String password;

  @ManyToMany(cascade = CascadeType.MERGE)
  @JoinTable(
          name = "user_role",
          joinColumns = @JoinColumn(
                  name = "id_user", referencedColumnName = "id_user"),
          inverseJoinColumns = @JoinColumn(
                  name = "id_role", referencedColumnName = "id_role"))
  private Collection< Role > roles;



  
}