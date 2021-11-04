package com.github.fabriciolfj.transacaoservice.interfaceadapter.providers.http.fraud;

import com.github.fabriciolfj.transacaoservice.interfaceadapter.TransactionNotFoundException;
import com.github.fabriciolfj.transacaoservice.domain.exceptions.domain.InfrastructureException;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FraudErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(final String describe, final Response response) {
        switch (response.status()) {
            case 400:
            case 404:
                return new TransactionNotFoundException();
            default:
                log.error("Fail consumer fraud. Details: {}, status: {}, msg: {}", response.body(), response.status(), describe);
                throw new InfrastructureException();
        }
    }
}
