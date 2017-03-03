package com.hellokoding.jpa.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Shamelessly stolen from http://stackoverflow.com/a/22368268
 *
 * Created by gwiley on 2/17/17.
 */
@Converter
public class BooleanToStringConverter implements AttributeConverter<Boolean, String> {

    @Override
    public String convertToDatabaseColumn(Boolean attribute) {
        return attribute != null && attribute.booleanValue() ? "Y" : "N";
    }

    @Override
    public Boolean convertToEntityAttribute(String dbData) {
        return "Y".equals(dbData);
    }
}
