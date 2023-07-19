package com.personetics.test.validator;

import java.util.Objects;

public class Node {
    private final String value;

    public Node(Integer value) {
        Objects.requireNonNull(value, "value cannot be null");
        this.value = value.toString();
    }

    public Node(String value) {
        Objects.requireNonNull(value, "value cannot be null");
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
