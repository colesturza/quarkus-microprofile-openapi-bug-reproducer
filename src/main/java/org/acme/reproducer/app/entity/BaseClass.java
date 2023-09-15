package org.acme.reproducer.app.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "Base_Class")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="clazz_", discriminatorType = DiscriminatorType.INTEGER)
public abstract class BaseClass {

    @Id
    @GeneratedValue
    @Column(name = "id")
    protected Long id;

    @Column(name = "shared_field")
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
