package com.github.fabriciolfj.transacaoservice.domain.exceptions;

import com.github.fabriciolfj.transacaoservice.domain.exceptions.enums.Errors;
import org.springframework.http.HttpStatus;

public class TransactionNotFoundException extends BaseException {

    public TransactionNotFoundException() {
        super(HttpStatus.NOT_FOUND, Errors.T_009);
    }
}
