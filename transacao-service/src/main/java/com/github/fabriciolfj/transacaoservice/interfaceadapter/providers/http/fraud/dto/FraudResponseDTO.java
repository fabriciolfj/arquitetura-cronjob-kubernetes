package com.github.fabriciolfj.transacaoservice.interfaceadapter.providers.http.fraud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FraudResponseDTO {

    private boolean fraud;
    private String uuid;
}
