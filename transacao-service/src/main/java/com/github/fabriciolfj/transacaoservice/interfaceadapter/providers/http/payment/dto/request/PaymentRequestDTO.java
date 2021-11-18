package com.github.fabriciolfj.transacaoservice.interfaceadapter.providers.http.payment.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PaymentRequestDTO {

    private String transaction;
    private BigDecimal value;
}
