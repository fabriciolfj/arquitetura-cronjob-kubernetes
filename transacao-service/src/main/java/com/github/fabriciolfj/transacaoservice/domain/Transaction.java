package com.github.fabriciolfj.transacaoservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
    private PaymentStatus paymentStatus;
    private LocalDateTime date;

    public Transaction updateStatus(final boolean isFraud) {
        status = isFraud ? TransactionStatus.INVALID : TransactionStatus.VALID;
        return this;
    }
}
