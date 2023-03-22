package me.tset.ordering.controller.dto;

import lombok.Data;
import me.tset.ordering.store.Sample;

import java.util.List;

@Data
public class CreateOrderingRequest {

    private String userId;

    private List<String> todos;

    private Sample sample;

    private List<Sample> samples;

}
