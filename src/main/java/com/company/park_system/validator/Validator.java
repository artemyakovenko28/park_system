package com.company.park_system.validator;

import java.util.Map;

public interface Validator<T> {
    Map<String, String> validate(T entity);
}