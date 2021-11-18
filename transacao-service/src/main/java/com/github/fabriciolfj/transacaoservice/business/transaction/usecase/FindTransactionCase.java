package com.github.fabriciolfj.transacaoservice.business.transaction.usecase;

import com.github.fabriciolfj.transacaoservice.business.transaction.GetTransaction;
import com.github.fabriciolfj.transacaoservice.domain.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindTransactionCase {

    private final GetTransaction getTransaction;

    public Transaction execute(final String uuid) {
        return getTransaction.find(uuid);
    }
}
