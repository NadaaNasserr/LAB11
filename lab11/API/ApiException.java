package com.example.lab11.API;




import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ApiException extends RuntimeException {
    public ApiException(String message){
        super(message);
    }
}