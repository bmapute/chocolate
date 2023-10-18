package com.bmapute.chocolate.application.resource;

import com.bmapute.chocolate.application.resource.request.enums.ChocolateType;
import com.bmapute.chocolate.application.resource.response.ChocolateMachineResponse;
import com.bmapute.chocolate.domain.service.ChocolateMachineService;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping(value = ResourcesConstants.API_BASE_PATH + "/check", produces = MediaType.APPLICATION_JSON_VALUE)
public class ChocolateMachineResource {
    private final ChocolateMachineService service;

    public ChocolateMachineResource(ChocolateMachineService service) {
        this.service = service;
    }

    @Operation(
            summary = "Chocolate Type Cacao Percentage",
            description = "Is used to see percentage for specif chocolate type"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @GetMapping("/{chocolateType}")
    ChocolateMachineResponse getPercentage(@PathVariable @NotNull ChocolateType chocolateType) {
        return service.getCacaoPercentage(chocolateType);
    }
}
