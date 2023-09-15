package org.acme.reproducer.app.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2")
public class SubClassB extends BaseClass {

    @Column(name = "field_b")
    private Double fieldB;

    public Double getFieldB() {
        return fieldB;
    }

    public void setFieldB(Double fieldB) {
        this.fieldB = fieldB;
    }
}
