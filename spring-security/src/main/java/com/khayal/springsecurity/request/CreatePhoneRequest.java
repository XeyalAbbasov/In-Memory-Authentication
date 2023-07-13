package com.khayal.springsecurity.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreatePhoneRequest {

    private String brand;
    private String model;
    private Double price;
    private String memory;
    private String RAM;
    private String color;
    private LocalDateTime localDateTime;
}
