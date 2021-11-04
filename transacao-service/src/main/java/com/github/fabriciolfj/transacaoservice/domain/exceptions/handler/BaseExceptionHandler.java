package com.github.fabriciolfj.transacaoservice.domain.exceptions.handler;


import com.github.fabriciolfj.transacaoservice.domain.exceptions.BaseException;
import com.github.fabriciolfj.transacaoservice.domain.exceptions.domain.DefaultErrorResponse;
import com.github.fabriciolfj.transacaoservice.domain.exceptions.domain.StandardError;
import com.github.fabriciolfj.transacaoservice.domain.exceptions.enums.Errors;
import feign.RetryableException;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.*;


public abstract class BaseExceptionHandler {

    private static final StandardError DEFAULT_ERROR = StandardError.builder()
            .status(INTERNAL_SERVER_ERROR.value())
            .timestamp(new Timestamp(System.currentTimeMillis()))
            .build();

    private final Logger log;
    private final Map<Class<?>, StandardError> exceptionMappings = new HashMap<>();

    BaseExceptionHandler(final Logger log) {
        this.log = log;
        registerMapping(ServletRequestBindingException.class, BAD_REQUEST);
        registerMapping(HttpMessageNotReadableException.class, BAD_REQUEST);
        registerMapping(MethodArgumentTypeMismatchException.class, BAD_REQUEST);
        registerMapping(MissingServletRequestParameterException.class, BAD_REQUEST);
        registerMapping(HttpRequestMethodNotSupportedException.class, METHOD_NOT_ALLOWED);
        registerMapping(HttpMediaTypeException.class, UNSUPPORTED_MEDIA_TYPE);
        registerMapping(RetryableException.class, INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<StandardError> handlerException(final Throwable ex, final HttpServletRequest request) {
        final StandardError mapping = exceptionMappings.getOrDefault(ex.getClass(), DEFAULT_ERROR);

        final DefaultErrorResponse defaultErrorResponse = DefaultErrorResponse.builder()
                .code(Errors.T_999.name())
                .message(Errors.T_999.getMessage(request.getLocale()))
                .build();

        final StandardError error = StandardError.builder()
                .error(defaultErrorResponse)
                .status(mapping.getStatus())
                .path(request.getRequestURI())
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .build();

        return ResponseEntity
                .status(mapping.getStatus())
                .body(error);
    }

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<StandardError> handlerBusinessException(final BaseException bbe, final HttpServletRequest request) {
        return ResponseEntity
                .status(bbe.getStatus())
                .body(bbe.getStandardError(request.getRequestURI(), request.getLocale()));
    }

    private void registerMapping(final Class<?> clazz, final HttpStatus status) {
        exceptionMappings.put(clazz, StandardError.builder()
                .status(status.value())
                .build());
    }
}
