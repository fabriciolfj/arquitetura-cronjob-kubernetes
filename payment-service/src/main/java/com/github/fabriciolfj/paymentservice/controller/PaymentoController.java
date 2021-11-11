package com.github.fabriciolfj.paymentservice.controller;

import com.github.fabriciolfj.paymentservice.controller.dto.request.PaymentRequestDTO;
import com.github.fabriciolfj.paymentservice.controller.dto.response.PaymentResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@Slf4j
@RestController
@RequestMapping("/api/v1/payments")
public class PaymentoController {

    private Random random = new Random();

    @PutMapping("/ticket")
    @ResponseStatus(HttpStatus.OK)
    public PaymentResponseDTO executeTicket(@RequestBody final PaymentRequestDTO dto) {
        log.info("Request ticket: {}", dto);

        if (random.nextInt() % 2 == 0) {
            return PaymentResponseDTO.builder()
                    .approved(true)
                    .describe("Payment accept")
                    .build();
        }

        return PaymentResponseDTO.builder()
                .approved(false)
                .describe("Disapproved payment")
                .build();
    }

    @PutMapping("/card")
    @ResponseStatus(HttpStatus.OK)
    public PaymentResponseDTO executeCard(@RequestBody final PaymentRequestDTO dto) {
        log.info("Request ticket: {}", dto);

        if (random.nextInt() % 2 == 0) {
            return PaymentResponseDTO.builder()
                    .approved(true)
                    .describe("Payment accept")
                    .build();
        }

        return PaymentResponseDTO.builder()
                .approved(false)
                .describe("Disapproved payment")
                .build();
    }

}
