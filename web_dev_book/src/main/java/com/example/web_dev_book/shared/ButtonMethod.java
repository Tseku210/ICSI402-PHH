package com.example.web_dev_book.shared;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface ButtonMethod {
    String buttonName() default "";
    boolean isDefault() default false;
}
