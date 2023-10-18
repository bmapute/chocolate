package com.bmapute.chocolate.domain.service;

import com.bmapute.chocolate.application.resource.request.enums.ChocolateType;
import com.bmapute.chocolate.application.resource.response.ChocolateMachineResponse;

public interface ChocolateMachineService {

    ChocolateMachineResponse getCacaoPercentage(ChocolateType chocolateType);
}
