package com.github.fabriciolfj.transacaoservice.interfaceadapter.providers.http.fraud.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FraudRequestDTO {

    private String uuid;
}
