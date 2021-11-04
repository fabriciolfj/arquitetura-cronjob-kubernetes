package com.github.fabriciolfj.transacaoservice.domain.exceptions.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DefaultErrorData implements Serializable {

    private static final long serialVersionUID = 5645077008627189857L;

    private String code;
    private List<DefaultErrorMessage> message;
    private Map<String, List<String>> fields;

    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        final DefaultErrorData that = (DefaultErrorData) o;
        return Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}
