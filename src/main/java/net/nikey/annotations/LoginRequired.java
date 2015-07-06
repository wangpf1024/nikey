package net.nikey.annotations;

/**
 * Created by arvin on 2015/7/2
 * @author 王鹏飞
 * @version 0.0.1
 * @since  2015/6/24
 */
import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface LoginRequired {}
