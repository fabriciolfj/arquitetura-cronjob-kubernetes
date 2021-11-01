package com.github.fabriciolfj.transacaoservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum TypeTransaction {

    DEBIT("debit"), CREDIT("credit"), OTHER("other");

    private String describe;

    public static void toType(final String type) {
        Stream.of(TypeTransaction.values())
                .filter(t -> t.getDescribe().equalsIgnoreCase(type))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Type not found: " + type));
    }
}
