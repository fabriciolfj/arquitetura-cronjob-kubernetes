package com.github.fabriciolfj.transacaoservice.interfaceadapter.providers.http.fraud;

import com.github.fabriciolfj.transacaoservice.interfaceadapter.providers.http.fraud.dto.FraudRequestDTO;
import com.github.fabriciolfj.transacaoservice.interfaceadapter.providers.http.fraud.dto.FraudResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "fraudClient", url = "${fraud.url}", configuration = FraudClientConfiguration.class)
public interface FraudClient {

    @PutMapping
    FraudResponseDTO execute(@RequestBody final FraudRequestDTO dto);
}
