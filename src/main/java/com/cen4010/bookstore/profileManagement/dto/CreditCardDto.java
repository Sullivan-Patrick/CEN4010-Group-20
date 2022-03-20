package com.cen4010.bookstore.profileManagement.dto;

import com.cen4010.bookstore.profileManagement.entity.CreditCardEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
public class CreditCardDto {

  private Long id; // might be redundant, left for organization

  @NotNull(message = "user_id should not be null")
  @NotNull(message = "user_id should not be null")
  @JsonProperty(value = "user_id") // postman overlay
  private UUID userId;

  @Pattern.List({
      @Pattern(regexp = "^[^<>%$@#]*$", message = "card_type should not be contains special characters")
  }
  )
  @NotEmpty(message = "card_type should not be empty")
  @NotNull(message = "card_type should not be null")
  @JsonProperty(value = "card_type") // postman overlay
  private String cardType;

  @Pattern.List({
      @Pattern(regexp = "^[^<>%$@#]*$", message = "display_name should not be contains special characters")
  }
  )
  @NotEmpty(message = "cardholder should not be empty")
  @NotNull(message = "cardholder should not be null")
  @JsonProperty(value = "cardholder") // postman overlay
  private String cardholder;

  @Pattern.List({
      @Pattern(regexp = "^[^<>%$@#]*$", message = "card_number should not be contains special characters")
  }
  )
  @NotEmpty(message = "card_number should not be empty")
  @NotNull(message = "card_number should not be null")
  @JsonProperty(value = "card_number") // postman overlay
  private String cardNumber;

  @JsonFormat(pattern = "yyyy-MM-dd")
  @NotNull(message = "expiry_date should not be null")
  @JsonProperty(value = "expiry_date") // postman overlay
  private LocalDate expiryDate;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  @JsonProperty(value = "full_name" // postman overlay not entered, taken from user
      , access = JsonProperty.Access.READ_ONLY)
  private String userFullName;

  @NotNull(message = "cvv should not be null")
  @Positive
  @Digits(fraction = 0, integer = 10, message ="Invalid cvv")
  @JsonProperty(value = "cvv") // postman overlay
  private Integer cvv;

  @NotEmpty(message = "address should not be empty")
  @NotNull(message = "address should not be null")
  @JsonProperty(value = "address") // postman overlay
  private String address;

  public CreditCardEntity toEntity(){
    CreditCardEntity entity = new CreditCardEntity();
    BeanUtils.copyProperties(this, entity);
    return entity;
  }
}
