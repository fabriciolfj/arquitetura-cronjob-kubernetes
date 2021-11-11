package com.github.fabriciolfj.transacaoservice.controller.mapper;

import com.github.fabriciolfj.transacaoservice.controller.dto.request.PaymentRequestDTO;
import com.github.fabriciolfj.transacaoservice.controller.dto.request.TransactionRequestDTO;
import com.github.fabriciolfj.transacaoservice.domain.Payment;
import com.github.fabriciolfj.transacaoservice.domain.PaymentStatus;
import com.github.fabriciolfj.transacaoservice.domain.Transaction;
import com.github.fabriciolfj.transacaoservice.domain.TypePayment;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class TransactionRequestDTOMapper {

    private TransactionRequestDTOMapper() { }

    public static Transaction toDomain(final TransactionRequestDTO dto){
        Assert.notNull(dto, "Request not null");
        Assert.notNull(dto.getDescribe(), "Describe not null");
        Assert.notNull(dto.getValue(), "Value transaction not null");
        Assert.notNull(dto.getPayments(), "Payments not null");
        Assert.notEmpty(dto.getPayments(), "Payments not informed");

        return Transaction.builder()
                .value(new BigDecimal(dto.getValue()))
                .uuid(dto.getUuid())
                .payments(dto.getPayments().stream().map(p -> toPayment(p)).collect(Collectors.toList()))
                .date(LocalDateTime.now())
                .describe(dto.getDescribe())
                .build();
    }

    private static Payment toPayment(final PaymentRequestDTO dto) {
        Assert.notNull(dto.getType(), "Type payment not null");
        Assert.notNull(dto.getValue(), "Value payment not null");

        return Payment.builder()
                .value(dto.getValue())
                .status(PaymentStatus.PENDING)
                .type(TypePayment.toType(dto.getType()))
                .build();
    }
}
