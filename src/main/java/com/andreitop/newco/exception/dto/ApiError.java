package com.andreitop.newco.exception.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ApiError {

    private final HttpStatus code;
    private final String message;
    private final LocalDateTime timestamp;

    public ApiError(HttpStatus code, String message) {
        this.code = code;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }
}
