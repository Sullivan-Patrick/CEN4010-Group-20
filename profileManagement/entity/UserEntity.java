package com.cen4010.bookstore.profileManagement.entity;

import com.cen4010.bookstore.profileManagement.dto.UserDto;

import java.util.UUID;
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
  private UUID id; // changed to UUID

  @Column(name = "Username", unique = true)
  private String username;

  @Column(name = "Password")
  private String password;

  @Column(name = "Full_Name")
  private String fullName;
/*
  Might add phone number and shipping address to bulk it up
*/
  public UserDto toDto(){
    UserDto entity = new UserDto();
    BeanUtils.copyProperties(this, entity);
    return entity;
  }
}
