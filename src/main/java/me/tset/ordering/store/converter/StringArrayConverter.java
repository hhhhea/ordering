package me.tset.ordering.store.converter;

import com.fasterxml.jackson.core.type.TypeReference;
import jakarta.persistence.Converter;

import java.util.List;

@Converter
public class StringArrayConverter extends JsonArrayConverter<String>{
    public StringArrayConverter() {
        super(new TypeReference<List<String>>() {
        });
    }
}
