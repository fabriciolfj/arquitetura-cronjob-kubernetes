package com.github.fabriciolfj.transacaoservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum TypePayment {

    CARD_VISA("cardVisa"), TICKET("ticket"), CARD_MASTER("cardMaster");

    private String describe;

    public static void toType(final String type) {
        Stream.of(TypePayment.values())
                .filter(t -> t.getDescribe().equalsIgnoreCase(type))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Type payment not found: " + type));
    }
}
