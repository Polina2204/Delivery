package com.jewelrystore.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Materials {
    GOLD("Золото"),
    SILVER("Серебро"),
    BRONZE("Бронза"),
    COPPER("Медь"),
    ;
    private final String name;
}
