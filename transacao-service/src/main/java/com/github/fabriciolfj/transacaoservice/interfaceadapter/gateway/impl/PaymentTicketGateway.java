package com.github.fabriciolfj.transacaoservice.interfaceadapter.gateway.impl;

import com.github.fabriciolfj.transacaoservice.domain.Payment;
import com.github.fabriciolfj.transacaoservice.domain.TypePayment;
import com.github.fabriciolfj.transacaoservice.interfaceadapter.gateway.MeansPaymentGateway;
import com.github.fabriciolfj.transacaoservice.interfaceadapter.providers.http.payment.PaymentClient;
import com.github.fabriciolfj.transacaoservice.interfaceadapter.providers.http.payment.mapper.PaymentRequestDTOMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PaymentTicketGateway implements MeansPaymentGateway {

    private final PaymentClient client;

    @Override
    public TypePayment getType() {
        return TypePayment.TICKET;
    }

    @Override
    public boolean execute(final Payment payment, final String transaction) {
        final var response = client.executeTicket(PaymentRequestDTOMapper.toRequest(payment, transaction));
        log.info("Response ticket: {}", response);

        return response.isApproved();
    }
}