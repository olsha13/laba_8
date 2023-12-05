package com.mus.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StatusOrdering {
    WAITING("В ожидании"),
    CONF("Подтверждено"),
    NOT_CONF("Не подтверждено"),
    DONE("Выполнено");

    private final String name;
}
