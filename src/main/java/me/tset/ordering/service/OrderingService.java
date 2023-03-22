package me.tset.ordering.service;

import lombok.RequiredArgsConstructor;
import me.tset.ordering.store.Ordering;
import me.tset.ordering.store.OrderingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OrderingService {
    private final OrderingRepository orderingRepository;

    public Ordering createOrdering(Ordering ordering) {
        return orderingRepository.save(ordering);
    }

    public Ordering updateOrdering(Long id, Ordering ordering) {
        ordering.setId(id);
        return orderingRepository.save(ordering);

    }

    public void deleteOrdering(Long id) {
        orderingRepository.deleteById(id);
    }

    public Optional<Ordering> getOneOrderingById(Long id) {
        return orderingRepository.findById(id);
    }

    public List<Ordering> getAllOrdering() {
        return orderingRepository.findAll();
    }
}
