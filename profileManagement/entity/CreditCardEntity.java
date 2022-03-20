package com.cen4010.bookstore.profileManagement.entity;

import com.cen4010.bookstore.profileManagement.dto.CreditCardDto;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "credit_card")
public class CreditCardEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "user_id") // same as User UUID ID
  private UUID userId;

  @Column(name = "card_type") // visa, mastercard, etc.
  private String cardType;

  @Column(name = "cardholder") // card owner
  private String cardholder;

  @Column(name = "card_number", unique = true)
  private String cardNumber;

  @Column(name = "expiry_date") // yyyy-MM-dd format
  private LocalDate expiryDate;

  @Column(name = "cvv")
  private Integer cvv;

  @Column(name = "address")
  private String address;

  public CreditCardDto toDto(){
    CreditCardDto entity = new CreditCardDto();
    BeanUtils.copyProperties(this, entity);
    return entity;
  }
}
