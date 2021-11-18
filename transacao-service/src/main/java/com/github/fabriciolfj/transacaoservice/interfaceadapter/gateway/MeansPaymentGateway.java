package com.github.fabriciolfj.transacaoservice.interfaceadapter.gateway;

import com.github.fabriciolfj.transacaoservice.domain.Payment;
import com.github.fabriciolfj.transacaoservice.domain.TypePayment;

public interface MeansPaymentGateway {

    TypePayment getType();

    boolean execute(final Payment payment, final String transaction);
}
