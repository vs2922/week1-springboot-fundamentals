package com.pharmainventory.inventory.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleNotFound(ResourceNotFoundException ex) {
        return new ErrorResponse("NOT_FOUND", ex.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleBadRequest(IllegalArgumentException ex) {
        return new ErrorResponse("BAD_REQUEST", ex.getMessage());
    }

    static class ErrorResponse {
        public String code, message;
        public ErrorResponse(String code, String message) {
            this.code = code;
            this.message = message;
        }
    }
}
