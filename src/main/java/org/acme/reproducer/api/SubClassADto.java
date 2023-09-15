package org.acme.reproducer.api;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SubClassADto extends BaseClassDto {
    
    @NotNull
    @JsonProperty(value = "field_a")
    private Double fieldA;

    public Double getFieldA() {
        return fieldA;
    }

    public void setFieldA(Double fieldA) {
        this.fieldA = fieldA;
    }
}
