package com.jewelrystore.repo;

import com.jewelrystore.model.Product;
import com.jewelrystore.model.enums.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    List<Product> findAllByCategory(Category category);
}
