package com.example.dateconverter.common;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime attribute) {
        if (attribute != null) {
            OffsetDateTime offsetDateTime = attribute.atZone(ZoneId.systemDefault()).toOffsetDateTime();
            ZonedDateTime atZoneSameInstant = offsetDateTime.atZoneSameInstant(ZoneId.of("UTC"));
            return Timestamp.valueOf(atZoneSameInstant.toLocalDateTime());
        }

        return null;
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp dbData) {
        if (dbData != null) {
            OffsetDateTime atOffset = dbData.toLocalDateTime().atOffset(ZoneOffset.UTC);
            ZonedDateTime atZoneSameInstant = atOffset.atZoneSameInstant(ZoneId.systemDefault());
            return atZoneSameInstant.toLocalDateTime();
        }

        return null;
    }

}
