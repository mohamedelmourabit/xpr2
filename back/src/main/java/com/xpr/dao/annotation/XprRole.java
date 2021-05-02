package com.xpr.dao.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface XprRole {
    public enum Role {
        CREATE,
        DELETE,
        LIST,
        UPDATE
    }
    Role role();

    String view() default "";
}