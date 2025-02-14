package com.sy.review.domain;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Converter
public class OTTSetConverter implements AttributeConverter<Set<OTT>, String> {

    @Override
    public String convertToDatabaseColumn(Set<OTT> attribute) {
        if (attribute == null || attribute.isEmpty()) {
            return "";
        }
        return attribute.stream()
                .map(OTT::name)
                .collect(Collectors.joining(","));
    }

    @Override
    public Set<OTT> convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) {
            return Set.of();
        }
        return Arrays.stream(dbData.split(","))
                .map(OTT::valueOf)
                .collect(Collectors.toSet());
    }
}
