package com.api.annotations;

/**
 * Created by arvin on 2015/6/24.
 * 非空注解类
 * @author 王鹏飞
 * @since  2015/6/24
 */
import java.lang.annotation.*;

@Target( { ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NotBlank {}
