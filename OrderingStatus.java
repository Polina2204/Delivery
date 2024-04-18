package com.jewelrystore.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderingStatus {
    ISSUED("Оформляется"),
    NOT_CONFIRMED("Не подтверждено"),
    CONFIRMED("Подтверждено"),
    SHIPPED("Доставлено"),
    ;

    private final String name;
}
