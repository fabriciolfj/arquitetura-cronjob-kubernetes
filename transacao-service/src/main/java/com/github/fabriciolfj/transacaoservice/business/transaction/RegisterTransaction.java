package com.github.fabriciolfj.transacaoservice.business.transaction;

import com.github.fabriciolfj.transacaoservice.domain.Transaction;

public interface RegisterTransaction {

    void save(final Transaction transaction);
}
