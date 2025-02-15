package com.sy.review.domain;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Converter
public class ChannelSetConverter implements AttributeConverter<Set<Channel>, String> {

    @Override
    public String convertToDatabaseColumn(Set<Channel> attribute) {
        if (attribute == null || attribute.isEmpty()) {
            return "";
        }
        return attribute.stream()
                .map(Channel::name)
                .collect(Collectors.joining(","));
    }

    @Override
    public Set<Channel> convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) {
            return Set.of();
        }
        return Arrays.stream(dbData.split(","))
                .map(Channel::valueOf)
                .collect(Collectors.toSet());
    }
}
