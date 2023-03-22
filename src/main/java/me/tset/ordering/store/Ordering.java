package me.tset.ordering.store;

import jakarta.persistence.*;
import lombok.Data;
import me.tset.ordering.store.converter.SampleArrayConverter;
import me.tset.ordering.store.converter.SampleConverter;
import me.tset.ordering.store.converter.StringArrayConverter;

import java.util.List;

@Data
@Entity
public class Ordering {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String userId;

    @Column(columnDefinition = "json")
    @Convert(converter = StringArrayConverter.class)
    private List<String> todos;

    @Column(columnDefinition = "json")
    @Convert(converter = SampleConverter.class)
    private Sample sample;

    @Column(columnDefinition = "json")
    @Convert(converter = SampleArrayConverter.class)
    private List<Sample> samples;




}
