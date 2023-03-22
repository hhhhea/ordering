package me.tset.ordering.store.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import org.springframework.util.StringUtils;

import java.util.List;

public class JsonArrayConverter<T> implements AttributeConverter<List<T>, String> {
    private final ObjectMapper objectMapper;

    private final TypeReference<List<T>> typeReference; // 2

    public JsonArrayConverter(TypeReference<List<T>> typeReference) {
        this.typeReference = typeReference;
        this.objectMapper  = new ObjectMapper();
    }


    @Override
    public String convertToDatabaseColumn(List<T> attribute) {
        if (attribute == null || attribute.isEmpty()) {
            return null;
        }
        try {
            return objectMapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<T> convertToEntityAttribute(String dbData) {
        if (StringUtils.hasText(dbData)) {
            try {
                return objectMapper.readValue(dbData, typeReference);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }
}
