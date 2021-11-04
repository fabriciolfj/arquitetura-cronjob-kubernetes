package com.github.fabriciolfj.transacaoservice.domain;

import com.github.fabriciolfj.transacaoservice.domain.exceptions.StatusTransactionException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum TransactionStatus {

    INVALID("invalid"), VALID("valid");

    private String describe;

    public static TransactionStatus toStatus(final String status) {
        return Stream.of(TransactionStatus.values())
                .filter(t ->  t.getDescribe().equalsIgnoreCase(status))
                .findFirst()
                .orElseThrow(() -> new StatusTransactionException());
    }
}
