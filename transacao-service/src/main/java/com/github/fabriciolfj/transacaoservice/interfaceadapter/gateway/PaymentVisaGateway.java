package com.github.fabriciolfj.transacaoservice.interfaceadapter.gateway;

import com.github.fabriciolfj.transacaoservice.business.payment.RegistryPayment;
import com.github.fabriciolfj.transacaoservice.domain.Payment;
import com.github.fabriciolfj.transacaoservice.domain.TypePayment;
import com.github.fabriciolfj.transacaoservice.interfaceadapter.providers.http.payment.PaymentClient;
import com.github.fabriciolfj.transacaoservice.interfaceadapter.providers.http.payment.mapper.PaymentRequestDTOMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PaymentVisaGateway implements RegistryPayment {

    private final PaymentClient client;

    @Override
    public TypePayment getType() {
        return TypePayment.CARD_VISA;
    }

    @Override
    public boolean execute(final Payment payment, final String transaction) {
        final var response = client.executeCard(PaymentRequestDTOMapper.toRequest(payment, transaction));
        log.info("Response visa: {}", response);

        return response.isApproved();
    }
}
