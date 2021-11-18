package com.github.fabriciolfj.transacaoservice.interfaceadapter.providers.http.payment;

import com.github.fabriciolfj.transacaoservice.interfaceadapter.providers.http.payment.dto.request.PaymentRequestDTO;
import com.github.fabriciolfj.transacaoservice.interfaceadapter.providers.http.payment.dto.response.PaymentResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "paymentClient", url = "${payment.url}", configuration = PaymentClientConfiguration.class)
public interface PaymentClient {

    @PutMapping("/ticket")
    PaymentResponseDTO executeTicket(@RequestBody final PaymentRequestDTO dto);

    @PutMapping("/card")
    PaymentResponseDTO executeCard(@RequestBody final PaymentRequestDTO dto);
}
