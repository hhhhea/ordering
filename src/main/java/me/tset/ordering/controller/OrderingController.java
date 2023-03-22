package me.tset.ordering.controller;


import lombok.RequiredArgsConstructor;
import me.tset.ordering.controller.dto.CreateOrderingRequest;
import me.tset.ordering.controller.dto.ErrorResponse;
import me.tset.ordering.controller.util.EntityDtoUtil;
import me.tset.ordering.service.OrderingService;
import me.tset.ordering.store.Ordering;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("orderings")
public class OrderingController {

    private final OrderingService orderingService;

    @PostMapping
    public Ordering create(@RequestBody CreateOrderingRequest request) {
        //EntityDtoUtil i = new EntityDtoUtil();
        return orderingService.createOrdering(EntityDtoUtil.toEntity(request));
    }

    @PutMapping("{id}")
    public Ordering update(@PathVariable Long id, @RequestBody Ordering ordering) {
        return orderingService.updateOrdering(id, ordering);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        orderingService.deleteOrdering(id);
    }

    @GetMapping("{id}")
    public Optional<Ordering> getOne(@PathVariable Long id) {
        return orderingService.getOneOrderingById(id);
    }

    @GetMapping
    public List<Ordering> getAll() {
        return orderingService.getAllOrdering();
    }

    @ExceptionHandler({DataIntegrityViolationException.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handle(DataIntegrityViolationException e) {
        return new ErrorResponse("DUPLICATE", e.getMessage());
    }


}
