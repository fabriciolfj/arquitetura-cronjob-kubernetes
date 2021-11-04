package com.github.fabriciolfj.transacaoservice.domain.exceptions.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DefaultErrorMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    private String lang;
    private String message;
}
