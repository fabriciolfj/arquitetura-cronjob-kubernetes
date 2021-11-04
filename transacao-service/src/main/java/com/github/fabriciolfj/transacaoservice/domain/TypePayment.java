package com.github.fabriciolfj.transacaoservice.domain;

import com.github.fabriciolfj.transacaoservice.domain.exceptions.domain.TypePaymentException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum TypePayment {

    CARD_VISA("cardVisa"), TICKET("ticket"), CARD_MASTER("cardMaster");

    private String describe;

    public static TypePayment toType(final String type) {
        return Stream.of(TypePayment.values())
                .filter(t -> t.getDescribe().equalsIgnoreCase(type))
                .findFirst()
                .orElseThrow(() -> new TypePaymentException());
    }
}
