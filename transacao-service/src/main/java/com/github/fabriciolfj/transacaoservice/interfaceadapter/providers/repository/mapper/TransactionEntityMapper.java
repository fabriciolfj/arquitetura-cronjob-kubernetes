package com.github.fabriciolfj.transacaoservice.interfaceadapter.providers.repository.mapper;

import com.github.fabriciolfj.transacaoservice.domain.*;
import com.github.fabriciolfj.transacaoservice.interfaceadapter.providers.repository.entities.PaymentEntity;
import com.github.fabriciolfj.transacaoservice.interfaceadapter.providers.repository.entities.TransactionEntity;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import static com.github.fabriciolfj.transacaoservice.domain.PaymentStatus.toStatus;

public class TransactionEntityMapper {

    private TransactionEntityMapper() { }

    public static Transaction toDomain(final TransactionEntity entity) {
        return Transaction.builder()
                .payments(entity.getPayments().stream().map(p -> toPaymentDomain(p)).collect(Collectors.toList()))
                .status(TransactionStatus.toStatus(entity.getStatus()))
                .describe(entity.getDescribe())
                .uuid(entity.getUuid())
                .value(entity.getValue())
                .date(LocalDateTime.parse(entity.getDate()))
                .build();
    }

    public static TransactionEntity toEntity(final Transaction transaction) {
        final var entity = TransactionEntity
                .builder()
                .describe(transaction.getDescribe())
                .status(transaction.getStatus().getDescribe())
                .uuid(transaction.getUuid())
                .value(transaction.getValue())
                .date(transaction.getDate().toString())
                .build();

        entity.setPayments(transaction
                .getPayments()
                .stream().map(p -> toPaymentEntity(p, entity))
                .collect(Collectors.toList()));

        return entity;
    }

    private static Payment toPaymentDomain(final PaymentEntity paymentEntity) {
        final var domain = Payment.builder()
                .type(TypePayment.toType(paymentEntity.getType()))
                .value(paymentEntity.getValue())
                .status(PaymentStatus.toStatus(paymentEntity.getStatus()))
                .build();

        return domain;
    }

    private static PaymentEntity toPaymentEntity(final Payment payment, final TransactionEntity transactionEntity) {
        final var entity = PaymentEntity.builder()
                .transaction(transactionEntity)
                .status(payment.getStatus().getDescribe())
                .type(payment.getType().getDescribe())
                .value(payment.getValue())
                .build();

        return entity;

    }
}
