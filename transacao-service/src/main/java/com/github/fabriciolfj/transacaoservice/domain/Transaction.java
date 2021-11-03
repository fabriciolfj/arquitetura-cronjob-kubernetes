package com.github.fabriciolfj.transacaoservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction {

    private String uuid;
    private String describe;
    private BigDecimal value;
    private TypePayment type;
    private TransactionStatus status;
}
