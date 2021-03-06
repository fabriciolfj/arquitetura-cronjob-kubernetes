package com.github.fabriciolfj.transacaoservice.controller.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionRequestDTO {

    @NotBlank(message = "{transaction.describe}")
    private String describe;
    @NotBlank(message = "{transaction.value}")
    private String value;
    @NotBlank(message = "{transaction.uuid}")
    private String uuid;
    @NotEmpty(message = "{transaction.payments}")
    private List<PaymentRequestDTO> payments;
}
