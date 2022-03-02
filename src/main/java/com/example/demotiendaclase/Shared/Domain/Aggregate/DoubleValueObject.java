package com.example.demotiendaclase.Shared.Domain.Aggregate;

import java.util.Objects;

public class DoubleValueObject {
    protected double value;

    public double value(){
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoubleValueObject that = (DoubleValueObject) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
