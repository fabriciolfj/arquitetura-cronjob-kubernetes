package com.github.fabriciolfj.paymentservice.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentRequestDTO {

    private String transaction;
    private BigDecimal value;
}
