package com.github.fabriciolfj.transacaoservice.business.transaction.usecase;

import com.github.fabriciolfj.transacaoservice.domain.Transaction;

public interface ValidationTransactionCase {

    void execute(final Transaction transaction);
}
