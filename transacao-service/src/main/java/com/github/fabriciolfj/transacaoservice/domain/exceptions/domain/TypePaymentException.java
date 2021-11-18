package com.github.fabriciolfj.transacaoservice.domain.exceptions.domain;

import com.github.fabriciolfj.transacaoservice.domain.exceptions.BaseException;
import com.github.fabriciolfj.transacaoservice.domain.exceptions.enums.Errors;
import org.springframework.http.HttpStatus;

import java.util.List;

public class TypePaymentException extends BaseException {

    public TypePaymentException() {
        super(HttpStatus.BAD_REQUEST, Errors.T_006);
    }
}
