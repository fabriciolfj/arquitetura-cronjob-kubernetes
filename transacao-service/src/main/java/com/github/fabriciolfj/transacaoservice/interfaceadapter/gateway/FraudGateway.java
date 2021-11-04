package com.github.fabriciolfj.transacaoservice.interfaceadapter.gateway;

import com.github.fabriciolfj.transacaoservice.business.transaction.EvaluateFraud;
import com.github.fabriciolfj.transacaoservice.domain.Transaction;
import com.github.fabriciolfj.transacaoservice.interfaceadapter.providers.http.fraud.FraudClient;
import com.github.fabriciolfj.transacaoservice.interfaceadapter.providers.http.fraud.mapper.FraudRequestDTOMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class FraudGateway implements EvaluateFraud {

    private final FraudClient fraudClient;

    @Override
    public boolean execute(Transaction transaction) {
        final var response = fraudClient.execute(FraudRequestDTOMapper.toDTO(transaction));
        return response.isFraud();
    }
}
