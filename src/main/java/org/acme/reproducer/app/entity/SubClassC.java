package org.acme.reproducer.app.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("3")
public class SubClassC extends BaseClass {

    @Column(name = "field_c")
    private Double fieldC;

    public Double getFieldC() {
        return fieldC;
    }

    public void setFieldC(Double fieldC) {
        this.fieldC = fieldC;
    }
}
