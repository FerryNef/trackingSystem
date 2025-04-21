package com.example.demo.exception;


import java.time.LocalDateTime;

public class ApiError {
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private String path;

    public ApiError(LocalDateTime now, int i, String notFound, String message, String requestURI) {
    }
}


