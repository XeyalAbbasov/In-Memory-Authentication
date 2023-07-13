package com.khayal.springsecurity.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UpdatePhoneRequest {

    private String brand;
    private String model;
    private Double price;
    private String Memory;
    private String RAM;
    private String color;
    private LocalDateTime publishDate;
}
