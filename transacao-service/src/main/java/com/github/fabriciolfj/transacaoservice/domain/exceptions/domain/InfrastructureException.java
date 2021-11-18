package com.github.fabriciolfj.transacaoservice.domain.exceptions.domain;

import com.github.fabriciolfj.transacaoservice.domain.exceptions.BaseException;
import com.github.fabriciolfj.transacaoservice.domain.exceptions.enums.Errors;
import org.springframework.http.HttpStatus;

public class InfrastructureException extends BaseException {

    public InfrastructureException() {
        super(HttpStatus.INTERNAL_SERVER_ERROR, Errors.T_001);
    }
}
