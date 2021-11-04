package com.github.fabriciolfj.transacaoservice.domain.exceptions.domain;

import com.github.fabriciolfj.transacaoservice.domain.exceptions.BaseException;
import com.github.fabriciolfj.transacaoservice.domain.exceptions.enums.Errors;
import org.springframework.http.HttpStatus;

public class PaymentStatusException extends BaseException {

    public PaymentStatusException() {
        super(HttpStatus.BAD_REQUEST, Errors.T_005);
    }
}
