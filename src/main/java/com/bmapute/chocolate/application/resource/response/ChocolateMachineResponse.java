package com.bmapute.chocolate.application.resource.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

public record ChocolateMachineResponse(
        @NotBlank String chocolateType, @Max(1) double cacauPercentage) {

    @JsonProperty("cacau_percentage")
    public String getcacauPercentage() {
        return (cacauPercentage * 100) + " %";
    }

    @Override
    public String chocolateType() {
        String[] elements = chocolateType.split("[.]");
        return elements[elements.length - 1];
    }
}
