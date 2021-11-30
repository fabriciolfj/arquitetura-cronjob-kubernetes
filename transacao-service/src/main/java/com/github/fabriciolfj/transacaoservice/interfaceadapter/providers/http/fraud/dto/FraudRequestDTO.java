package com.github.fabriciolfj.transacaoservice.interfaceadapter.providers.http.fraud.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FraudRequestDTO {

    @JsonProperty("id")
    private String uuid;
}
