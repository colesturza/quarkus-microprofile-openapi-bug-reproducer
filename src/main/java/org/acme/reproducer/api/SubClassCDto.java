package org.acme.reproducer.api;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SubClassCDto extends BaseClassDto {
    
    @NotNull
    @JsonProperty(value = "field_c")
    private Double fieldC;

    public Double getFieldC() {
        return fieldC;
    }

    public void setFieldC(Double fieldC) {
        this.fieldC = fieldC;
    }
}
