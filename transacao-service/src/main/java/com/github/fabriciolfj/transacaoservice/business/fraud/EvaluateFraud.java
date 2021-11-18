package com.github.fabriciolfj.transacaoservice.business.fraud;

import com.github.fabriciolfj.transacaoservice.domain.Transaction;

public interface EvaluateFraud {

    boolean execute(final Transaction transaction);
}
