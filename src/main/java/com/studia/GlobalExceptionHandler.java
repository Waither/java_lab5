package com.studia;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<Map<String, Object>> handleResponseStatusException(ResponseStatusException ex, HttpServletRequest request) {
        Map<String, Object> errorDetails = new LinkedHashMap<>();
        errorDetails.put("timestamp", LocalDateTime.now());
        errorDetails.put("status", ex.getStatusCode().value());

        String error = (ex.getStatusCode() instanceof HttpStatus)
                ? ((HttpStatus) ex.getStatusCode()).getReasonPhrase()
                : "Unknown Error";
        errorDetails.put("error", error);

        errorDetails.put("message", ex.getReason());
        errorDetails.put("path", request.getRequestURI());
        return ResponseEntity.status(ex.getStatusCode()).body(errorDetails);
    }
}
