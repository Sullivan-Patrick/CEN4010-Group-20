package com.cen4010.bookstore.profileManagement.exception;

import com.cen4010.bookstore.profileManagement.dto.ErrorResponseDto;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/*
  GlobalErrorAdvice returns message if user enters same username (email)
  in account creation, or if password does not meet length, or other
  requirements etc. Will add more when adding other endpoints.

 */

@ControllerAdvice
public class GlobalErrorAdvice extends ResponseEntityExceptionHandler {

  @ExceptionHandler(DuplicateRecordException.class)
  public ResponseEntity<ErrorResponseDto> handleDuplicateRecordException(DuplicateRecordException ex) {

    ErrorResponseDto errorResponseDto = ErrorResponseDto.builder()
        .errorCode(Constant.ERR001)
        .message(ex.getMessage())
        .variable(ex.getVariable()).build();

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponseDto);
  }

  @ExceptionHandler(RecordNotFoundException.class)
  public ResponseEntity<ErrorResponseDto> handleRecordNotFoundException(RecordNotFoundException ex) {

    ErrorResponseDto errorResponseDto = ErrorResponseDto.builder()
        .errorCode(Constant.ERR003)
        .message(ex.getMessage())
        .variable(ex.getVariable()).build();

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseDto);
  }

  @ExceptionHandler(GeneralException.class)
  public ResponseEntity<ErrorResponseDto> handleGeneralException(GeneralException ex) {

    ErrorResponseDto errorResponseDto = ErrorResponseDto.builder()
        .errorCode(Constant.ERR004)
        .message(ex.getMessage())
        .variable(ex.getVariable()).build();

    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponseDto);
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
      HttpHeaders headers, HttpStatus status,
      WebRequest request) {
    String message;
    if (ex.getMessage().contains("password")){
      message = "Password must be at least 8 characters mix with numbers and characters";
    }
    else if(ex.getMessage().contains("full_name")){
      message = "Full name must not contain numbers / Special Characters / Empty values are not allowed";
    }
    else if(ex.getMessage().contains("card_name")){
      message = "card_name must not contain numbers / Special Characters / Empty values are not allowed";
    }
    else if(ex.getMessage().contains("expiry_date")){
      message = "expiry_date should be formatted yyyy-MM-dd / Empty values are not allowed";
    }
    else{
      message = ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();
    }

    ErrorResponseDto errorResponseDto = ErrorResponseDto.builder()
        .errorCode(Constant.ERR002)
        .message(message)
        .variable("Error while validating request").build();

    return ResponseEntity.status(status).body(errorResponseDto);
  }
}