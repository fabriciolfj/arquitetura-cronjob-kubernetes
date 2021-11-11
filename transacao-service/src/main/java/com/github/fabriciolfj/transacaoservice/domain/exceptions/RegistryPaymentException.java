package com.github.fabriciolfj.transacaoservice.domain.exceptions;

import com.github.fabriciolfj.transacaoservice.domain.exceptions.enums.Errors;
import org.springframework.http.HttpStatus;

public class RegistryPaymentException extends BaseException {

    public RegistryPaymentException() {
        super(HttpStatus.BAD_REQUEST, Errors.T_007);
    }
}
