package com.github.fabriciolfj.transacaoservice.interfaceadapter.gateway;

import com.github.fabriciolfj.transacaoservice.business.payment.MakePayment;
import com.github.fabriciolfj.transacaoservice.domain.Payment;
import com.github.fabriciolfj.transacaoservice.domain.TypePayment;
import com.github.fabriciolfj.transacaoservice.domain.exceptions.RegistryPaymentException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PaymentGateway implements MakePayment {

    private final List<MeansPaymentGateway> registryPayments;

    @Override
    public boolean execute(final Payment payment, final String uuid) {
        return registryPayments
                .stream()
                .filter(r -> isType(r.getType(), payment.getType()))
                .findFirst()
                .map(reg -> reg.execute(payment, uuid))
                .orElseThrow(() -> new RegistryPaymentException());
    }

    private boolean isType(final TypePayment registry, final TypePayment payment) {
        return registry.getDescribe().equalsIgnoreCase(payment.getDescribe());
    }
}
