package com.jewelrystore.model;

import com.jewelrystore.model.enums.Category;
import com.jewelrystore.model.enums.Materials;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String name;
    private double price;
    @Enumerated(EnumType.STRING)
    private Category category;
    @Enumerated(EnumType.STRING)
    private Materials material;
    private int warranty;
    private String file;
    private int quantity;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ordering> orderingList;

    @OneToOne(cascade = CascadeType.ALL)
    private StatProduct statProduct;

    public Product(String name, double price, Category category, int warranty, int quantity, Materials material) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.warranty = warranty;
        this.quantity = quantity;
        this.material = material;
    }

    public void update(String name, double price, Category category, int warranty, int quantity, Materials material) {
        this.material = material;
        this.name = name;
        this.price = price;
        this.category = category;
        this.warranty = warranty;
        this.quantity = quantity;
    }

    public void addOrdering(Ordering ordering) {
        orderingList.add(ordering);
        ordering.setProduct(this);
    }

    public void removeQuantity(int quantity) {
        this.quantity -= quantity;
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }
}
