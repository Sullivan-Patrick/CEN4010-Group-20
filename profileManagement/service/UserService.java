package com.cen4010.bookstore.profileManagement.service;

import com.cen4010.bookstore.profileManagement.dto.UserDto;

import java.util.List;
import org.springframework.http.ResponseEntity;

public interface UserService {

  ResponseEntity<UserDto> save(UserDto dto);

  ResponseEntity<UserDto> update(UserDto dto, Long userId);

  ResponseEntity<List<UserDto>> getCards();

  /*
    To be added another save and getCards()
    when adding other endpoints
   */



}


