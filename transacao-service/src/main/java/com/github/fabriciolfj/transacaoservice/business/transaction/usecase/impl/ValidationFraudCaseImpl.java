package com.github.fabriciolfj.transacaoservice.business.transaction.usecase.impl;

import com.github.fabriciolfj.transacaoservice.business.transaction.usecase.ValidationTransactionCase;
import com.github.fabriciolfj.transacaoservice.domain.Transaction;
import com.github.fabriciolfj.transacaoservice.domain.TransactionStatus;
import com.github.fabriciolfj.transacaoservice.domain.exceptions.TransactionFraudException;
import org.springframework.stereotype.Component;

@Component
public class ValidationFraudCaseImpl implements ValidationTransactionCase {

    @Override
    public void execute(final Transaction transaction) {
        if (transaction.getStatus().getDescribe().equalsIgnoreCase(TransactionStatus.INVALID.getDescribe())) {
            throw new TransactionFraudException();
        }
    }
}
