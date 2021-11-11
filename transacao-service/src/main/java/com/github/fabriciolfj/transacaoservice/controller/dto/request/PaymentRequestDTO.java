package com.github.fabriciolfj.transacaoservice.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequestDTO {

    @NotBlank(message = "{payment.type}")
    private String type;
    @NotNull(message = "{payment.value}")
    private BigDecimal value;
}
