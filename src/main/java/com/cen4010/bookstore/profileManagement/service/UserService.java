package com.cen4010.bookstore.profileManagement.service;

import com.cen4010.bookstore.profileManagement.dto.UserDto;
import com.cen4010.bookstore.profileManagement.dto.CreditCardDto;

import java.util.UUID;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface UserService {

  ResponseEntity<UserDto> save(UserDto dto);

  ResponseEntity<UserDto> update(UserDto dto, UUID userId);

  ResponseEntity<List<UserDto>> getCards();

  ResponseEntity<CreditCardDto> save(CreditCardDto dto);

  ResponseEntity<List<CreditCardDto>> getCards(UUID userId);
}

