package com.cen4010.bookstore.profileManagement.entity;

import com.cen4010.bookstore.profileManagement.dto.UserDto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "users")
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "Username", unique = true)
  private String username;

  @Column(name = "Password")
  private String password;

  @Column(name = "Full_Name")
  private String fullName;
/*
  To be added phone number and shipping address
*/
  public UserDto toDto(){
    UserDto entity = new UserDto();
    BeanUtils.copyProperties(this, entity);
    return entity;
  }
}
