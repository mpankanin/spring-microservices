package com.springmicroservices.student_app.util;

import lombok.Value;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Objects;

@Component
public class Patcher {

    public static <T> void patch(T existingObject, T patchObject) throws IllegalAccessException {
        Field[] fields = existingObject.getClass().getDeclaredFields();
        for (Field field : fields) {// make the field accessible (private -> public)
            field.setAccessible(true);

            Object value = field.get(patchObject);
            if (value != null) {
                field.set(existingObject, value);
            }

            // make the field inaccessible (public -> private)
            field.setAccessible(false);
        }
    }

}
