package org.acme.reproducer.api;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
@JsonSubTypes({
        @JsonSubTypes.Type(value = SubClassADto.class),
        @JsonSubTypes.Type(value = SubClassBDto.class),
        @JsonSubTypes.Type(value = SubClassCDto.class)
})
public abstract class BaseClassDto {

    @NotNull
    @JsonProperty(value = "id")
    protected Long id;

    @NotNull
    @JsonProperty(value = "shared_field")
    protected Double sharedField;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getSharedField() {
        return sharedField;
    }

    public void setSharedField(Double sharedField) {
        this.sharedField = sharedField;
    }
}
