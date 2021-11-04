package com.github.fabriciolfj.transacaoservice.controller.mapper;

import com.github.fabriciolfj.transacaoservice.controller.dto.TransactionRequestDTO;
import com.github.fabriciolfj.transacaoservice.domain.PaymentStatus;
import com.github.fabriciolfj.transacaoservice.domain.Transaction;
import com.github.fabriciolfj.transacaoservice.domain.TypePayment;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionRequestDTOMapper {

    private TransactionRequestDTOMapper() { }

    public static Transaction toDomain(final TransactionRequestDTO dto){
        Assert.notNull(dto, "Request not null");
        Assert.notNull(dto.getDescribe(), "Describe not null");
        Assert.notNull(dto.getType(), "Type not null");
        Assert.notNull(dto.getValue(), "Value transaction not null");

        return Transaction.builder()
                .type(TypePayment.toType(dto.getType()))
                .value(new BigDecimal(dto.getValue()))
                .uuid(dto.getUuid())
                .paymentStatus(PaymentStatus.PENDING)
                .date(LocalDateTime.now())
                .describe(dto.getDescribe())
                .build();
    }
}
