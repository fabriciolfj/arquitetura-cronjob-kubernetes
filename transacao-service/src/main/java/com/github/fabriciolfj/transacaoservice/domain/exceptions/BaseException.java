package com.github.fabriciolfj.transacaoservice.domain.exceptions;

import com.github.fabriciolfj.transacaoservice.domain.exceptions.domain.DefaultErrorData;
import com.github.fabriciolfj.transacaoservice.domain.exceptions.domain.DefaultErrorResponse;
import com.github.fabriciolfj.transacaoservice.domain.exceptions.domain.StandardError;
import com.github.fabriciolfj.transacaoservice.domain.exceptions.enums.Errors;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Getter
@AllArgsConstructor
public class BaseException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1L;

    private final HttpStatus status;
    private final Errors errors;
    private final List<DefaultErrorData> error;

    protected BaseException(final HttpStatus httpStatus, final Errors errors) {
        this.status = httpStatus;
        this.errors = errors;
        this.error = new ArrayList<>();
    }

    public final StandardError getStandardError(final String path, final Locale messageLocale) {
        return StandardError.builder()
                .path(path)
                .status(status.value())
                .error(buildKnownErrorList(messageLocale))
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .build();
    }

    protected DefaultErrorResponse buildKnownErrorList(final Locale messageLocale) {
        return DefaultErrorResponse.builder()
                .code(errors.name())
                .message(errors.getMessage(messageLocale))
                .build();
    }
}
