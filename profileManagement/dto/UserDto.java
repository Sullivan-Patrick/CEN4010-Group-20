package com.cen4010.bookstore.profileManagement.dto;

import com.cen4010.bookstore.profileManagement.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserDto {

  private UUID id = UUID.randomUUID();

  // Static Username (email)
  @NotEmpty(message = "Username should not be empty")
  @NotNull(message = "Username should not be null")
  @JsonProperty(value = "Username") // postman overlay
  private String username;


  // Password w/Rules and stipulations
  @Size(min = 8, message = "Password must be at least 8 characters")
  @Pattern.List({
      @Pattern(regexp = "(?=.*[0-9]).+"), // needs work during error response
      @Pattern(regexp = "(?=.*[a-z]).+")
  })
  @JsonProperty(value =  "Password", // postman overlay
      access = JsonProperty.Access.READ_WRITE)
  private String password;


  // Full Name w/ Rules and stipulations
  @Pattern.List({
      @Pattern(regexp = "^[^<>%$@#]*$", message =
          "Full Name should not contain special characters")
  }
  )
  @NotEmpty(message = "Full Name should not be empty")
  @NotNull(message = "Full Name should not be null")
  @JsonProperty(value = "Full_Name") // postman overlay
  private String fullName;

  /*
    To be added, shipping_address and phone_number
    to bulk up account info etc.
   */


  public UserEntity toEntity(){
    UserEntity entity = new UserEntity();
    BeanUtils.copyProperties(this, entity);
    return entity;
  }

}
