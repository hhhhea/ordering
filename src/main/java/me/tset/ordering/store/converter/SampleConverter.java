package me.tset.ordering.store.converter;

import jakarta.persistence.Converter;
import me.tset.ordering.store.Sample;

@Converter
public class SampleConverter extends JsonConverter<Sample> {
    public SampleConverter() {
        super(Sample.class);
    }
}
