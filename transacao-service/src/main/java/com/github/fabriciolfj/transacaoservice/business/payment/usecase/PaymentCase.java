package com.github.fabriciolfj.transacaoservice.business.payment.usecase;

import com.github.fabriciolfj.transacaoservice.business.payment.MakePayment;
import com.github.fabriciolfj.transacaoservice.domain.Payment;
import com.github.fabriciolfj.transacaoservice.domain.PaymentStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentCase {

    private final MakePayment makePayment;

    public Payment execute(final Payment payment, final String uuid) {
        final var result = makePayment.execute(payment, uuid);
        return Payment.builder()
                .status(result ? PaymentStatus.APPROVED : PaymentStatus.DISAPPROVED)
                .value(payment.getValue())
                .type(payment.getType())
                .build();
    }


}
