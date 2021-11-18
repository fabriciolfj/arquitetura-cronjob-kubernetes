package com.github.fabriciolfj.transacaoservice.interfaceadapter.providers.http.fraud.mapper;

import com.github.fabriciolfj.transacaoservice.domain.Transaction;
import com.github.fabriciolfj.transacaoservice.interfaceadapter.providers.http.fraud.dto.FraudRequestDTO;

public class FraudRequestDTOMapper {
    
    private FraudRequestDTOMapper() { }
    
    public static FraudRequestDTO toDTO(final Transaction transaction) {
        return FraudRequestDTO.builder()
                .uuid(transaction.getUuid())
                .build();
    }
}
