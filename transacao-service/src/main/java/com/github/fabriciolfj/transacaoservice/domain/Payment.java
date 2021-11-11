package com.github.fabriciolfj.transacaoservice.domain;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {

    private PaymentStatus status;
    private TypePayment type;
    private BigDecimal value;
}
