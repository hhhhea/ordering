package me.tset.ordering.store.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;

public class JsonConverter<T> implements AttributeConverter<T, String> {
    private final ObjectMapper objectMapper;
    private final Class<T>     type;

    public JsonConverter(Class<T> type) {
        //T sample3;
        //Sample2 sample3;
        this.type         = type;
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public String convertToDatabaseColumn(T attribute) {
        if (attribute == null) {
            return null;
        }
        try {
            return objectMapper.writeValueAsString(attribute);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public T convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        try {
            return objectMapper.readValue(dbData, type);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
