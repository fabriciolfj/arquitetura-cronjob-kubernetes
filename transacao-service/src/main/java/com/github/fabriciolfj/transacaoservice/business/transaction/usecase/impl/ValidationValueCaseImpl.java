package com.github.fabriciolfj.transacaoservice.business.transaction.usecase.impl;

import com.github.fabriciolfj.transacaoservice.business.transaction.usecase.ValidationTransactionCase;
import com.github.fabriciolfj.transacaoservice.domain.Transaction;
import com.github.fabriciolfj.transacaoservice.domain.exceptions.TransactionPaymentException;
import org.springframework.stereotype.Component;

@Component
public class ValidationValueCaseImpl implements ValidationTransactionCase {

    @Override
    public void execute(final Transaction transaction) {
        final var sum = transaction.getTotalPayments();

        if (transaction.getValue().compareTo(sum) != 0) {
            throw new TransactionPaymentException();
        }
    }
}
