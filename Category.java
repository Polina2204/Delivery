package com.jewelrystore.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Category {
    RING("Кольца"),
    NECKLACE("Ожерелье"),
    BRACELETS("Браслеты"),
    CHAINS("Цепочки"),
    EARRINGS("Сережки"),
    ;
    private final String name;
}
