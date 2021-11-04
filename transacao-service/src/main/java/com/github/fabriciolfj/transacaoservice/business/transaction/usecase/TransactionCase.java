package com.github.fabriciolfj.transacaoservice.business.transaction.usecase;

import com.github.fabriciolfj.transacaoservice.business.transaction.RegisterTransaction;
import com.github.fabriciolfj.transacaoservice.domain.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TransactionCase {

    private final RegisterTransaction registerTransaction;
    private final FraudeCase fraudeCase;

    public void execute(final Transaction transaction) {
        final var transactionUpdated = fraudeCase.execute(transaction);
        registerTransaction.save(transactionUpdated);
    }

}
