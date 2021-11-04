package com.github.fabriciolfj.transacaoservice.controller;

import com.github.fabriciolfj.transacaoservice.business.transaction.usecase.TransactionCase;
import com.github.fabriciolfj.transacaoservice.controller.dto.TransactionRequestDTO;
import com.github.fabriciolfj.transacaoservice.controller.mapper.TransactionRequestDTOMapper;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/api/v1/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionCase transactionCase;

    @PostMapping
    @ApiOperation(
            value = "Create transaction",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Transaction return successfully"),
            @ApiResponse(code = 500, message = "Internal server error"),
            @ApiResponse(code = 502, message = "Bad gateway")
    })
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody final TransactionRequestDTO dto) {
        log.info("Request received: {}", dto.toString());
        transactionCase.execute(TransactionRequestDTOMapper.toDomain(dto));
    }
}
