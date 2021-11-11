package com.github.fabriciolfj.transacaoservice.business.payment;

import com.github.fabriciolfj.transacaoservice.domain.Payment;
import com.github.fabriciolfj.transacaoservice.domain.TypePayment;

public interface RegistryPayment {

    TypePayment getType();

    boolean execute(final Payment payment, final String transaction);
}
