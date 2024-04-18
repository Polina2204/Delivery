package com.jewelrystore.repo;

import com.jewelrystore.model.Ordering;
import com.jewelrystore.model.enums.OrderingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderingRepo extends JpaRepository<Ordering, Long> {
    List<Ordering> findAllByUser_IdAndOrderingStatus(Long userId, OrderingStatus orderingStatus);
}
