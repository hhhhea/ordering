package me.tset.ordering.store;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderingRepository extends JpaRepository<Ordering,Long> {

    //List<Ordering> findAllByUserId(String userId);
}
