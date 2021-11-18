package com.github.fabriciolfj.transacaoservice.interfaceadapter.providers.http.payment.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponseDTO {

    private String describe;
    private boolean approved;

}
