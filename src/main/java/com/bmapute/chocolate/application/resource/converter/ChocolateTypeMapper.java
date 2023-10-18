package com.bmapute.chocolate.application.resource.converter;

import com.bmapute.chocolate.application.resource.request.enums.ChocolateType;
import com.bmapute.chocolate.domain.CacaoCalculator;
import com.bmapute.chocolate.domain.ChocolateTypeA;
import com.bmapute.chocolate.domain.ChocolateTypeB;
import com.bmapute.chocolate.domain.ChocolateTypeC;
import org.springframework.stereotype.Component;

@Component
public class ChocolateTypeMapper {
    public CacaoCalculator toDomain(ChocolateType value){
        return switch (value){
            case CHOCOLATE_TYPE_A-> new ChocolateTypeA();
            case CHOCOLATE_TYPE_B-> new ChocolateTypeB();
            case CHOCOLATE_TYPE_C-> new ChocolateTypeC();
            default -> throw new IllegalArgumentException("The chocolate type cannot by mapped");
        };
    }
}
