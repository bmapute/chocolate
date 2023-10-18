package com.bmapute.chocolate.domain.service;

import com.bmapute.chocolate.application.resource.converter.ChocolateTypeMapper;
import com.bmapute.chocolate.application.resource.request.enums.ChocolateType;
import com.bmapute.chocolate.application.resource.response.ChocolateMachineResponse;
import com.bmapute.chocolate.domain.CacaoCalculator;
import com.bmapute.chocolate.domain.ChocolateMachineProducer;

public class ChocolateMachineDomainService implements ChocolateMachineService {

    private final ChocolateMachineProducer chocolateProducer;
    private final ChocolateTypeMapper converter;

    public ChocolateMachineDomainService(ChocolateMachineProducer chocolateProducer, ChocolateTypeMapper converter) {
        this.chocolateProducer = chocolateProducer;
        this.converter = converter;
    }


    @Override
    public ChocolateMachineResponse getCacaoPercentage(ChocolateType chocolateType) {
        CacaoCalculator calculator = converter.toDomain(chocolateType);
        var result = chocolateProducer.calculateCacaoPercentage(calculator);
        return new ChocolateMachineResponse(calculator.getClass().getName(), result);
    }
}
