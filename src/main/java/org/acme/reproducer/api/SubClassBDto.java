package org.acme.reproducer.api;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SubClassBDto extends BaseClassDto {
    
    @NotNull
    @JsonProperty(value = "field_b")
    private Double fieldB;

    public Double getFieldB() {
        return fieldB;
    }

    public void setFieldB(Double fieldB) {
        this.fieldB = fieldB;
    }
}
