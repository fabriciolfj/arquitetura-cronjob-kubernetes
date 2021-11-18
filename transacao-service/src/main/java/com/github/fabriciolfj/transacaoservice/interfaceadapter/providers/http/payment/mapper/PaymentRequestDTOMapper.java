package com.github.fabriciolfj.transacaoservice.interfaceadapter.providers.http.payment.mapper;

import com.github.fabriciolfj.transacaoservice.domain.Payment;
import com.github.fabriciolfj.transacaoservice.interfaceadapter.providers.http.payment.dto.request.PaymentRequestDTO;

public class PaymentRequestDTOMapper {

    private PaymentRequestDTOMapper() {

    }

    public static PaymentRequestDTO toRequest(final Payment payment, final String uuid) {
        return PaymentRequestDTO.builder()
                .transaction(uuid)
                .value(payment.getValue())
                .build();
    }
}
