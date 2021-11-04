package com.github.fabriciolfj.transacaoservice.interfaceadapter.providers.http.fraud;

import feign.Logger;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FraudClientConfiguration {

    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public ErrorDecoder fraudDecoder() {
        return new FraudErrorDecoder();
    }
}
