package com.github.fabriciolfj.transacaoservice.business.payment.usecase;

import com.github.fabriciolfj.transacaoservice.business.payment.RegistryPayment;
import com.github.fabriciolfj.transacaoservice.domain.Payment;
import com.github.fabriciolfj.transacaoservice.domain.PaymentStatus;
import com.github.fabriciolfj.transacaoservice.domain.TypePayment;
import com.github.fabriciolfj.transacaoservice.domain.exceptions.RegistryPaymentException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PaymentCase {

    private final List<RegistryPayment> registryPayments;

    public Payment execute(final Payment payment, final String uuid) {
        return registryPayments
                .stream()
                .filter(r -> isType(r.getType(), payment.getType()))
                .findFirst()
                .map(registry -> registry.execute(payment, uuid))
                .map(effective -> Payment.builder()
                            .status(effective ? PaymentStatus.APPROVED : PaymentStatus.DISAPPROVED)
                            .value(payment.getValue())
                            .type(payment.getType())
                            .build())
                .orElseThrow(() -> new RegistryPaymentException());
    }

    private boolean isType(final TypePayment registry, final TypePayment payment) {
        return registry.getDescribe().equalsIgnoreCase(payment.getDescribe());
    }
}
