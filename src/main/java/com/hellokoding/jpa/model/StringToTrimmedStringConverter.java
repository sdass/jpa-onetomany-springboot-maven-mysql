package com.hellokoding.jpa.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Trim Strings coming from the database.
 *
 * Created by gwiley on 3/2/17.
 */
@Converter
public class StringToTrimmedStringConverter implements AttributeConverter<String, String> {

    @Override
    public String convertToDatabaseColumn(String attribute) {
        return attribute;
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        return dbData == null ? null : dbData.trim();
    }
}
