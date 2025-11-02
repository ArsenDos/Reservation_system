package kz.com.reservation.reservation.task.service.exception;

import java.time.LocalDateTime;

public record ErrorResponse(String errorMessage, LocalDateTime localDateTime) {
}
