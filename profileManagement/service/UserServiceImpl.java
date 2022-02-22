package com.cen4010.bookstore.profileManagement.service;

import com.cen4010.bookstore.profileManagement.dto.UserDto;
import com.cen4010.bookstore.profileManagement.entity.UserEntity;
import com.cen4010.bookstore.profileManagement.exception.DuplicateRecordException;
import com.cen4010.bookstore.profileManagement.exception.RecordNotFoundException;
import com.cen4010.bookstore.profileManagement.repository.UserRepository;

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

  @Autowired
  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public ResponseEntity<UserDto> save(UserDto dto) {

    UserEntity entity;
    try {
      log.info("Saving User Details");

      entity = dto.toEntity();
      entity = userRepository.save(entity);

    } catch (DataIntegrityViolationException e) {
      log.error("Error when saving User Details");
      throw new DuplicateRecordException("Cannot save duplicate Usernames", dto.getUsername());
    }

    log.info("Completed saving User Details");

    return ResponseEntity.status(HttpStatus.OK).body(entity.toDto());
  }

  @Override
  public ResponseEntity<UserDto> update(UserDto dto, Long userId) {

    log.info("Updating User Details");

    UserEntity entityExist = userRepository.findById(userId).orElseThrow(() ->
        new RecordNotFoundException("User Not Found", dto.getUsername()));

    entityExist.setPassword(dto.getPassword());
    entityExist.setFullName(dto.getFullName());

    entityExist = userRepository.save(entityExist);

    log.info("Completed Updating User Details");

    return ResponseEntity.status(HttpStatus.OK).body(entityExist.toDto());

  }

  @Override
  public ResponseEntity<List<UserDto>> getCards() {

    List<UserDto> userDtos = userRepository.findAll()
        .stream().map(UserEntity::toDto).collect(Collectors.toList());

    return ResponseEntity.status(HttpStatus.OK).body(userDtos);
  }

}
