package ru.mathemator.demo.reactjs.dto;


import lombok.Data;

import java.time.Instant;

@Data
public class ResultRowDto {
    private Instant sentAt;
    private String requestId;
    private String traceId;
    private String deliveryTime;
    private String body;
    private String error;

}
