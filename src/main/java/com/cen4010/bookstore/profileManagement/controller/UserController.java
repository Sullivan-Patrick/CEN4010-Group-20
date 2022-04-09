package com.cen4010.bookstore.profileManagement.controller;

import com.cen4010.bookstore.profileManagement.dto.UserDto;
import com.cen4010.bookstore.profileManagement.dto.CreditCardDto;
import com.cen4010.bookstore.profileManagement.service.UserService;

import java.util.UUID;
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
  @PutMapping("users/update/{userId}") // unsure about having the UUID in address bar
  ResponseEntity<UserDto> update(
      @Valid @RequestBody UserDto dto,
      @PathVariable(value = "userId") UUID userId){
    return userService.update(dto, userId);
  }

  /*
   * Getting specific users
   * @return
   */
  @GetMapping("users/profile/{userId}")
  ResponseEntity<List<UserDto>> get(
      @PathVariable(value = "userId") UUID userId // unsure about having the UUID in address bar
  ){
    return userService.get(userId);
  }

  /*
   * Adds credit card to user
   * @param dto
   * @return
   */
  @PostMapping("users/cards")
  ResponseEntity<CreditCardDto> save(@Valid @RequestBody CreditCardDto dto){
    return userService.save(dto);
  }

  /*
   * Retrieves credit card list per user account
   * @param userId
   * @return
   */
  @GetMapping("users/cards/{userId}")
  ResponseEntity<List<CreditCardDto>> getCards(
      @PathVariable(value = "userId") UUID userId // unsure about having the UUID in address bar
  ){
    return userService.getCards(userId);
  }

}
