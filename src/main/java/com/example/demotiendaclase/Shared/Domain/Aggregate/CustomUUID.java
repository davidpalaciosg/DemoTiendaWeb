package com.example.demotiendaclase.Shared.Domain.Aggregate;

import java.util.Objects;
import java.util.UUID;

public class CustomUUID {

    private String value;

    public CustomUUID(String value) {
        validate(value);
        this.value = value;
    }

    public String value(){
        return this.value;
    }

    private void validate(String value){
        validFormat(value);
    }

    private void validFormat(String value){
        try{
            //Directamente desde Java Utils
            UUID.fromString(value);
        }
        catch (Exception ex)
        {
            throw new RuntimeException("El UUID no tiene formato válido");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomUUID that = (CustomUUID) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
