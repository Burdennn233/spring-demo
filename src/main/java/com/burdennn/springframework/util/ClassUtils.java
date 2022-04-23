package com.burdennn.springframework.util;

public class ClassUtils {

    public static ClassLoader getDefaultClassLoader() {
        ClassLoader cl = null;

        try {
            cl = Thread.currentThread().getContextClassLoader();
        } catch (Throwable e) {
            // fallback
        }

        if (cl == null) {
            cl = ClassUtils.class.getClassLoader();
        }

        return cl;
    }
}
