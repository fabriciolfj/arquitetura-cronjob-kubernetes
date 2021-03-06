package com.github.fabriciolfj.fraudesservice.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FraudResponseDTO {

    private boolean fraud;
    private String uuid;
}
