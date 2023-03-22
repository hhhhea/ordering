package me.tset.ordering.store.converter;

import com.fasterxml.jackson.core.type.TypeReference;
import jakarta.persistence.Converter;
import me.tset.ordering.store.Sample;

@Converter
public class SampleArrayConverter extends JsonArrayConverter<Sample> {


    public SampleArrayConverter() {
        super(new TypeReference<>() {
        });
    }
}
