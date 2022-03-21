package com.cen4010.bookstore.profileManagement.repository;

import com.cen4010.bookstore.profileManagement.entity.UserEntity;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

  Optional<UserEntity> findById(UUID userId);

}