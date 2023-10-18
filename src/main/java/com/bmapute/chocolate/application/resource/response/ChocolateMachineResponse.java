package com.bmapute.chocolate.application.resource.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ChocolateMachineResponse(String chocolateType, double cacauPercentage) {

    @JsonProperty("cacau_percentage")
    public String getcacauPercentage() {
        return (cacauPercentage * 100) + " %";
    }

    @Override
    public String chocolateType() {
        String[] elements = chocolateType.split("[.]");
        return elements[elements.length-1];
    }
}
