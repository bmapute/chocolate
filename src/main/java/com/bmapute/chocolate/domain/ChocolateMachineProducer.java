package com.bmapute.chocolate.domain;

import com.bmapute.chocolate.domain.exception.DomainException;

public class ChocolateMachineProducer {
    private double cacaoPercentage;

    public double calculateCacaoPercentage(CacaoCalculator calculator) {
        if (calculator == null) throw new DomainException("The chocolate type cannot be null or empty");
        return calculator.cacaoPercentageCalculate();
    }

}
