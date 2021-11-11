package com.github.fabriciolfj.transacaoservice.interfaceadapter.providers.http.payment;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentClientConfiguration {

    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public PaymentErrorDecorder errorDecorder() {
        return new PaymentErrorDecorder();
    }
}
