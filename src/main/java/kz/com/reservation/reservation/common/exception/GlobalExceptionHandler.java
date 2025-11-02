package kz.com.reservation.reservation.common.exception;


import kz.com.reservation.reservation.task.service.exception.BadRequestException;
import kz.com.reservation.reservation.task.service.exception.ErrorResponse;
import kz.com.reservation.reservation.task.service.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;


@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> handleBadRequest(BadRequestException ex){
        log.warn(ex.getMessage());
        var errorResp = new ErrorResponse(ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(errorResp, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException (NotFoundException ex){
        log.warn(ex.getMessage());
        var errorResp = new ErrorResponse(ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(errorResp, HttpStatus.NOT_FOUND);
    }




}
