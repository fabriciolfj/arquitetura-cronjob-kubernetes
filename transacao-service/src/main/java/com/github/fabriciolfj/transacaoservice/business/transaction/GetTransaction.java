package com.github.fabriciolfj.transacaoservice.business.transaction;

import com.github.fabriciolfj.transacaoservice.domain.Transaction;

public interface GetTransaction {

    Transaction find(final String uuid);
}
