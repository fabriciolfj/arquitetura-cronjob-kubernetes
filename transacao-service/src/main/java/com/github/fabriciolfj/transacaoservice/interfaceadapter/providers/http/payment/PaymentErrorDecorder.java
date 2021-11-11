package com.github.fabriciolfj.transacaoservice.interfaceadapter.providers.http.payment;

import com.github.fabriciolfj.transacaoservice.domain.exceptions.TransactionPaymentException;
import com.github.fabriciolfj.transacaoservice.domain.exceptions.domain.InfrastructureException;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PaymentErrorDecorder implements ErrorDecoder {

    @Override
    public Exception decode(final String msg, final Response response) {
        switch (response.status()) {
            case 400:
            case 404:
                return new TransactionPaymentException();
            default:
                log.error("Fail consumer payment. Details: {}, status: {}, msg: {}", response.body(), response.status(), msg);
                return new InfrastructureException();
        }
    }
}
