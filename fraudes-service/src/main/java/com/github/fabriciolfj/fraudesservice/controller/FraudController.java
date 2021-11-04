package com.github.fabriciolfj.fraudesservice.controller;

import com.github.fabriciolfj.fraudesservice.controller.dto.FraudRequestDTO;
import com.github.fabriciolfj.fraudesservice.controller.dto.FraudResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/api/v1/fraud")
@RequiredArgsConstructor
public class FraudController {

    private final Random random = new Random();

    @PutMapping
    public FraudResponseDTO update(@RequestBody final FraudRequestDTO dto) {
        if (random.nextInt() % 2 == 0) {
            return FraudResponseDTO
                    .builder()
                    .fraud(true)
                    .uuid(dto.getUuid())
                    .build();
        }

        return FraudResponseDTO
                .builder()
                .fraud(false)
                .uuid(dto.getUuid())
                .build();
    }
}
