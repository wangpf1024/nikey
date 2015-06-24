package com.api.annotations;

/**
 * Created by arvin on 2015/6/24.
 */
import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface APIAccessCheckRequired {}
