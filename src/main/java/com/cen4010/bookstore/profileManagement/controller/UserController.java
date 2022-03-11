package com.cen4010.bookstore.profileManagement.controller;

import com.cen4010.bookstore.profileManagement.dto.UserDto;
import com.cen4010.bookstore.profileManagement.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  /*
   * Creating user account
   * @param dto
   * @return saved object
   */
  @PostMapping("users/login")
  ResponseEntity<UserDto> save(@Valid @RequestBody UserDto dto){
    return userService.save(dto);
  }

  /*
   * Updating user in database
   * @param dto
   * @return
   */
  @PutMapping("users/update/{userId}")
  ResponseEntity<UserDto> update(
      @Valid @RequestBody UserDto dto,
      @PathVariable(value = "userId") Long userId){
    return userService.update(dto, userId);
  }

  /*
   * Getting all users, temp for testing
   * @return
   */
  @GetMapping("users/all")
  ResponseEntity<List<UserDto>> get(){
    return userService.getCards();
  }

  /*
    To be added PUT and GET request for credit cards
   */


}
