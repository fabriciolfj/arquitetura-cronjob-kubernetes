package com.github.fabriciolfj.transacaoservice.business.fraud.usecase;

import com.github.fabriciolfj.transacaoservice.business.fraud.EvaluateFraud;
import com.github.fabriciolfj.transacaoservice.domain.Transaction;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class FraudeCase {

    private final EvaluateFraud evaluateFraud;

    public Transaction execute(final Transaction transaction) {
        final var isFraud = evaluateFraud.execute(transaction);
        log.info("Return fraude: {}", isFraud ? "identified" : "not identified");
        return transaction.updateStatus(isFraud);
    }
}
