package com.cen4010.bookstore.profileManagement.service;

import com.cen4010.bookstore.profileManagement.dto.UserDto;
import com.cen4010.bookstore.profileManagement.dto.CreditCardDto;
import com.cen4010.bookstore.profileManagement.entity.UserEntity;
import com.cen4010.bookstore.profileManagement.entity.CreditCardEntity;
import com.cen4010.bookstore.profileManagement.exception.DuplicateRecordException;
import com.cen4010.bookstore.profileManagement.exception.RecordNotFoundException;
import com.cen4010.bookstore.profileManagement.repository.UserRepository;
import com.cen4010.bookstore.profileManagement.repository.CreditCardRepository;

import java.util.UUID;
import lombok.extern.slf4j.Slf4j; // simple logging facade for Java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final CreditCardRepository creditCardRepository;

  @Autowired
  public UserServiceImpl(UserRepository userRepository,
      CreditCardRepository creditCardRepository) {
    this.userRepository = userRepository;
    this.creditCardRepository = creditCardRepository;
  }

  /* ******************************************************************************************** */
  @Override
  public ResponseEntity<UserDto> save(UserDto dto) {

    UserEntity entity;
    try {
      log.info("SAVING USER DETAILS");

      entity = dto.toEntity();
      entity = userRepository.save(entity);

    } catch (DataIntegrityViolationException e) {
      log.error("ERROR WHILE SAVING USER DETAILS");
      throw new DuplicateRecordException("CANNOT SAVE DUPLICATE USERS", dto.getUsername());
    }

    log.info("COMPLETED SAVING USER DETAILS");

    return ResponseEntity.status(HttpStatus.OK).body(entity.toDto());
  }

  /* ******************************************************************************************** */
  @Override
  public ResponseEntity<UserDto> update(UserDto dto, UUID userId) {

    log.info("UPDATING USER DETAILS");

    UserEntity entityExist = userRepository.findById(userId).orElseThrow(() ->
        new RecordNotFoundException("USER NOT FOUND", dto.getUsername()));

    entityExist.setPassword(dto.getPassword());
    entityExist.setFullName(dto.getFullName());

    entityExist = userRepository.save(entityExist);

    log.info("COMPLETED UPDATING USER DETAILS");

    return ResponseEntity.status(HttpStatus.OK).body(entityExist.toDto());

  }

  /* ******************************************************************************************** */
  @Override
  public ResponseEntity<List<UserDto>> getCards() {

    List<UserDto> userDtos = userRepository.findAll()
        .stream().map(UserEntity::toDto).collect(Collectors.toList());

    return ResponseEntity.status(HttpStatus.OK).body(userDtos);
  }
  /* ******************************************************************************************** */
  @Override
  public ResponseEntity<CreditCardDto> save(CreditCardDto dto) {

    log.info("SAVING USER CARD DETAILS");

    userRepository.findById(dto.getUserId()).orElseThrow(() ->
        new RecordNotFoundException("USER NOT FOUND", String.valueOf(dto.getUserId())));

    CreditCardEntity entity = dto.toEntity();

    try {
      entity = creditCardRepository.save(entity);
    } catch (DataIntegrityViolationException e) {
      log.error("ERROR WHILE SAVING USER CARD DETAILS");
      throw new DuplicateRecordException("CANNOT SAVE DUPLICATE CARD NUMBERS", dto.getCardNumber());
    }

    log.info("COMPLETED SAVING USER CARD DETAILS");

    return ResponseEntity.status(HttpStatus.OK).body(entity.toDto());
  }
  /* ******************************************************************************************** */
  @Override
  public ResponseEntity<List<CreditCardDto>> getCards(UUID userId) {

    List<CreditCardDto> list = creditCardRepository.findByUserId(userId)
        .stream().map(this::updateEntity).collect(Collectors.toList());

    return ResponseEntity.status(HttpStatus.OK).body(list);
  }
  /* ******************************************************************************************** */
  private CreditCardDto updateEntity(CreditCardEntity entity) {

    UserEntity userEntity = userRepository.findById(entity.getUserId()).orElseThrow(() ->
        new RecordNotFoundException("USER NOT FOUND", String.valueOf(entity.getUserId())));

    CreditCardDto dto = entity.toDto();
    dto.setUserFullName(userEntity.getFullName());

    return dto;
  }
}
