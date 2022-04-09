package com.cen4010.bookstore.profileManagement.repository;

import com.cen4010.bookstore.profileManagement.entity.UserEntity;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserEntity, UUID> {

  Optional<UserEntity> findById(UUID userId);

}