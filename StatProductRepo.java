package com.jewelrystore.repo;

import com.jewelrystore.model.StatProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatProductRepo extends JpaRepository<StatProduct, Long> {

}
