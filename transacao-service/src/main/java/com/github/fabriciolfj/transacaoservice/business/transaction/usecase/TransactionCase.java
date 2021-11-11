package com.github.fabriciolfj.transacaoservice.business.transaction.usecase;

import com.github.fabriciolfj.transacaoservice.business.fraud.usecase.FraudeCase;
import com.github.fabriciolfj.transacaoservice.business.payment.usecase.PaymentCase;
import com.github.fabriciolfj.transacaoservice.business.transaction.RegisterTransaction;
import com.github.fabriciolfj.transacaoservice.domain.Payment;
import com.github.fabriciolfj.transacaoservice.domain.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TransactionCase {

    private final RegisterTransaction registerTransaction;
    private final FraudeCase fraudeCase;
    private final List<ValidationTransactionCase> validations;
    private final PaymentCase paymentCase;

    public void execute(final Transaction transaction) {
        validations.stream().forEach(v -> v.execute(transaction));

        final var transactionUpdated = fraudeCase.execute(transaction);

        transactionUpdated.setPayments(updatePayments(transactionUpdated));

        registerTransaction.save(transactionUpdated);
    }

    private List<Payment> updatePayments(final Transaction transactionUpdated) {
        return transactionUpdated
                .getPayments()
                .stream()
                .map(pay -> paymentCase.execute(pay, transactionUpdated.getUuid()))
                .collect(Collectors.toList());
    }

}
