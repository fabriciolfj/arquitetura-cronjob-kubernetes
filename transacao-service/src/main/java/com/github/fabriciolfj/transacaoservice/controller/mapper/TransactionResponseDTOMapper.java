package com.github.fabriciolfj.transacaoservice.controller.mapper;

import com.github.fabriciolfj.transacaoservice.controller.dto.response.PaymentResponseDTO;
import com.github.fabriciolfj.transacaoservice.controller.dto.response.TransactionResponseDTO;
import com.github.fabriciolfj.transacaoservice.domain.Payment;
import com.github.fabriciolfj.transacaoservice.domain.Transaction;

import java.util.stream.Collectors;

public class TransactionResponseDTOMapper {

    private TransactionResponseDTOMapper() {

    }

    public static final TransactionResponseDTO toResponse(final Transaction transaction) {
        return TransactionResponseDTO
                .builder()
                .describe(transaction.getDescribe())
                .uuid(transaction.getUuid())
                .payments(transaction.getPayments().stream().map(p -> toResponse(p)).collect(Collectors.toList()))
                .build();
    }

    private static final PaymentResponseDTO toResponse(final Payment payment) {
        return PaymentResponseDTO
                .builder()
                .type(payment.getType().getDescribe())
                .value(payment.getValue())
                .build();
    }
}
