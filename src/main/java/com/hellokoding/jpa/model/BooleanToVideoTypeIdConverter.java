package com.hellokoding.jpa.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;



/**
 * On the way back from the database, convert null to false, non-null to true. This is
 * consistent with the way the rest of the system handles a video type id.
 *
 * On the way to the database, convert false to null, true to Integer = 3 ( the value
 * of the "Unlimited Video" video subscription ). Any non-null value that doesn't violate
 * the "RI" triggers would suffice, went with "Unlimited Video" since it most closely
 * represents how that value is interpreted by the rest of the entitlement system.
 *
 * Created by gwiley on 2/21/17.
 */
@Converter
public class BooleanToVideoTypeIdConverter implements AttributeConverter<Boolean, Integer> {

    static final Integer UNLIMITED_VIDEO_TYPE_ID = 3;
    @Override
    public Integer convertToDatabaseColumn(Boolean attribute) {
        return attribute != null && attribute.booleanValue() ? UNLIMITED_VIDEO_TYPE_ID : null;
    }

    @Override
    public Boolean convertToEntityAttribute(Integer dbData) {
        return dbData != null;
    }
}
