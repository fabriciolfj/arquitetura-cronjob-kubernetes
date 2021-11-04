package com.github.fabriciolfj.transacaoservice.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;

@Getter
@RequiredArgsConstructor
public enum PaymentStatus {

    APPROVED("approved"),
    PENDING("pending"),
    DISAPPROVED("disapproved");

    private final String describe;

    public static PaymentStatus toStatus(final String status) {
        return Stream.of(PaymentStatus.values())
                .filter(t ->  t.getDescribe().equalsIgnoreCase(status))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Status not found: " + status));
    }
}
