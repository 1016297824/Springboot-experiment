package com.example.experiment04.aspect;

import java.lang.annotation.*;


@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface MyInterceptor {
    AuthorityType[] value() default AuthorityType.USER;

    public static enum AuthorityType {
        USER, ADMIN, SUPERADMIN;
    }
}