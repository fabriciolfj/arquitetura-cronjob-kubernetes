package com.github.fabriciolfj.transacaoservice.domain.exceptions;

import com.github.fabriciolfj.transacaoservice.domain.exceptions.enums.Errors;
import org.springframework.http.HttpStatus;

public class StatusTransactionException extends BaseException {

    public StatusTransactionException() {
        super(HttpStatus.BAD_REQUEST, Errors.T_004);
    }
}
