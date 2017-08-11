package com.devianta;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public interface Saver {
    static void save(TextContainer tc) {
        Class<TextContainer> cl = TextContainer.class;

        if (!cl.isAnnotationPresent(SaveTo.class)) {
            throw new IllegalArgumentException();
        }

        SaveTo pathAnnotation = cl.getAnnotation(SaveTo.class);
        String path = pathAnnotation.path();

        try {
            Method[] methods = cl.getMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(Save.class)) {
                    method.invoke(tc, path);
                    break;
                }
            }
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
