package com.bmapute.chocolate.infrastructure;

import com.bmapute.chocolate.application.resource.converter.ChocolateTypeMapper;
import com.bmapute.chocolate.domain.ChocolateMachineProducer;
import com.bmapute.chocolate.domain.service.ChocolateMachineDomainService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public ChocolateMachineDomainService ChocolateMachineDomainService(ChocolateTypeMapper converter){
        return new ChocolateMachineDomainService(new ChocolateMachineProducer(),converter);
    }
}
