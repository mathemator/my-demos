package ru.mathemator.demo.reactjs.dto;

import lombok.Data;

@Data
public class ResultRequestPayload {
    private String memberId;
    private String esiaId;
    private String traceId;
    private boolean allTraceIds;
}