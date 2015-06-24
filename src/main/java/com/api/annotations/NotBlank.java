package com.api.annotations;

/**
 * Created by arvin on 2015/6/24.
 * 非空注解
 */
import java.lang.annotation.*;

@Target( { ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NotBlank {}
