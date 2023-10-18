package com.bmapute.chocolate.domain.service;

import com.bmapute.chocolate.application.resource.converter.ChocolateTypeMapper;
import com.bmapute.chocolate.application.resource.request.enums.ChocolateType;
import com.bmapute.chocolate.domain.ChocolateMachineProducer;
import com.bmapute.chocolate.domain.ChocolateTypeB;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ChocolateMachineDomainServiceTest {
    private static final double CHOCOLATE_TYPE_B_PERCENTAGE = 0.85;
    private static final String CHOCOLATE_TYPE_B_CLASS_NAME = "ChocolateTypeB";
    @Mock
    private ChocolateTypeMapper mapper;
    @Mock
    private ChocolateMachineProducer machineProducer;
    @InjectMocks
    private ChocolateMachineDomainService chocolateMachineService;
    private AutoCloseable closeable;

    @BeforeEach
    void initService() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void closeService() throws Exception {
        closeable.close();
    }

    @Test
    void getCacaoPercentage() {

        var type = ChocolateType.CHOCOLATE_TYPE_B;
        var calculator = new ChocolateTypeB();
        when(mapper.toDomain(type)).thenReturn(calculator);
        when(machineProducer.calculateCacaoPercentage(calculator)).thenReturn(CHOCOLATE_TYPE_B_PERCENTAGE);
        var response = chocolateMachineService.getCacaoPercentage(type);
        assertEquals(CHOCOLATE_TYPE_B_PERCENTAGE, response.cacauPercentage());
        assertEquals(CHOCOLATE_TYPE_B_CLASS_NAME, response.chocolateType());
    }

}