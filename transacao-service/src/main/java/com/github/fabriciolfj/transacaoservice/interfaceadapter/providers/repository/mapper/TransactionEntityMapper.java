package com.github.fabriciolfj.transacaoservice.interfaceadapter.providers.repository.mapper;

import com.github.fabriciolfj.transacaoservice.domain.Transaction;
import com.github.fabriciolfj.transacaoservice.domain.TransactionStatus;
import com.github.fabriciolfj.transacaoservice.domain.TypePayment;
import com.github.fabriciolfj.transacaoservice.interfaceadapter.providers.repository.entities.TransactionEntity;

import java.time.LocalDateTime;

import static com.github.fabriciolfj.transacaoservice.domain.PaymentStatus.toStatus;

public class TransactionEntityMapper {

    private TransactionEntityMapper() { }

    public static Transaction toDomain(final TransactionEntity entity) {
        return Transaction.builder()
                .paymentStatus(toStatus(entity.getPaymentStatus()))
                .status(TransactionStatus.toStatus(entity.getStatus()))
                .describe(entity.getDescribe())
                .uuid(entity.getUuid())
                .value(entity.getValue())
                .type(TypePayment.toType(entity.getType()))
                .date(LocalDateTime.parse(entity.getDate()))
                .build();
    }

    public static TransactionEntity toEntity(final Transaction transaction) {
        return TransactionEntity
                .builder()
                .describe(transaction.getDescribe())
                .status(transaction.getStatus().getDescribe())
                .type(transaction.getType().getDescribe())
                .uuid(transaction.getUuid())
                .paymentStatus(transaction.getPaymentStatus().getDescribe())
                .value(transaction.getValue())
                .date(transaction.getDate().toString())
                .build();
    }
}
