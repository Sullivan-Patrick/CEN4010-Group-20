package com.cen4010.bookstore.profileManagement.repository;

import com.cen4010.bookstore.profileManagement.entity.CreditCardEntity;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CreditCardRepository extends JpaRepository<CreditCardEntity, UUID> {

  List<CreditCardEntity> findByUserId(UUID userId);

}