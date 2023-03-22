package me.tset.ordering.controller.util;

import me.tset.ordering.controller.dto.CreateOrderingRequest;
import me.tset.ordering.store.Ordering;

public class EntityDtoUtil {
    public static Ordering toEntity(CreateOrderingRequest createOrderingRequest) {
        Ordering ordering = new Ordering();
        ordering.setUserId(createOrderingRequest.getUserId());
        ordering.setTodos(createOrderingRequest.getTodos());
        ordering.setSample(createOrderingRequest.getSample());
        ordering.setSamples(createOrderingRequest.getSamples());
        return ordering;
    }
}
