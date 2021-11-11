package com.github.fabriciolfj.transacaoservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction {

    private String uuid;
    private String describe;
    private BigDecimal value;
    private TransactionStatus status;
    private List<Payment> payments;
    private LocalDateTime date;

    public Transaction updateStatus(final boolean isFraud) {
        status = isFraud ? TransactionStatus.INVALID : TransactionStatus.VALID;
        return this;
    }

    public BigDecimal getTotalPayments() {
        return payments.stream().map(p -> p.getValue())
                .reduce(BigDecimal.ZERO, (x,y) -> x.add(y));
    }
}
