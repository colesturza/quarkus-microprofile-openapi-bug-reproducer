package org.acme.reproducer.app.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class SubClassA extends BaseClass {
    
    @Column(name =  "field_a")
    private Double fieldA;

    public Double getFieldA() {
        return fieldA;
    }

    public void setFieldA(Double fieldA) {
        this.fieldA = fieldA;
    }
}
