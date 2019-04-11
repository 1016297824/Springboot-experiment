package com.example.experiment04.aspect;



import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, METHOD})
public @interface MyInterceptor {
    AuthorityType[] value() default AuthorityType.USER;

    public static enum AuthorityType {
        USER, ADMIN, SUPERADMIN;
    }
}
