package com.jewelrystore.repo;

import com.jewelrystore.model.Masters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MastersRepo extends JpaRepository<Masters, Long> {
}
