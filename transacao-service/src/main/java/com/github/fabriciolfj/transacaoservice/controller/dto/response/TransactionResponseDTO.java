package com.github.fabriciolfj.transacaoservice.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionResponseDTO {

    private String uuid;
    private String describe;
    private List<PaymentResponseDTO> payments;
}
