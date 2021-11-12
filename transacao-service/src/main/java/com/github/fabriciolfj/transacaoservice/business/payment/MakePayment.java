package com.github.fabriciolfj.transacaoservice.business.payment;

import com.github.fabriciolfj.transacaoservice.domain.Payment;

public interface MakePayment {

    boolean execute(final Payment payment, final String uuid);
}
