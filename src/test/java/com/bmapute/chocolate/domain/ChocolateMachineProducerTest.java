package com.bmapute.chocolate.domain;

import com.bmapute.chocolate.domain.exception.DomainException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChocolateMachineProducerTest {
    private ChocolateMachineProducer chocolateProducer;
    private static final double CHOCOLATE_TYPE_A_PERCENTAGE = 0.8;
    private static final double CHOCOLATE_TYPE_B_PERCENTAGE = 0.85;
    private static final double CHOCOLATE_TYPE_C_PERCENTAGE = 0.9;
    private static final String ERROR_MESSAGE = "The chocolate type cannot be null or empty";

    @BeforeEach
    public void setUp() {
        chocolateProducer = new ChocolateMachineProducer();
    }

    @Test
    public void whenPassNullChocolateType_ReturnException() {
        RuntimeException aThrows = assertThrows(DomainException.class, () -> {
            chocolateProducer.calculateCacaoPercentage(null);
        }, ERROR_MESSAGE);
        assertEquals(ERROR_MESSAGE, aThrows.getMessage());
    }

    @Test
    public void whenPassChocolateTYpeA_Return80() {
        var chocolateTypeA = new ChocolateTypeA();
        assertEquals(CHOCOLATE_TYPE_A_PERCENTAGE,
                chocolateProducer.calculateCacaoPercentage(chocolateTypeA));
    }

    @Test
    public void whenPassChocolateTYpeB_Return85() {
        ChocolateTypeB chocolateTypeB = new ChocolateTypeB();
        var result = chocolateProducer.calculateCacaoPercentage(chocolateTypeB);
        assertEquals(CHOCOLATE_TYPE_B_PERCENTAGE, result);
    }

    @Test
    public void whenPassChocolateTYpeC_Return90() {
        assertEquals(CHOCOLATE_TYPE_C_PERCENTAGE, chocolateProducer.calculateCacaoPercentage(new ChocolateTypeC()));
    }
}