package com.github.fabriciolfj.fraudesservice.controller;

import com.github.fabriciolfj.fraudesservice.controller.dto.FraudRequestDTO;
import com.github.fabriciolfj.fraudesservice.controller.dto.FraudResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/api/v1/fraud")
@RequiredArgsConstructor
public class FraudController {

    private final Random random = new Random();

    @PutMapping
    @ResponseStatus(HttpStatus.BAD_REQUEST)
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
