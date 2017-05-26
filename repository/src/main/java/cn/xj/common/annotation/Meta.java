package cn.xj.common.annotation;

import java.lang.annotation.*;

/**
 * Created by Welink on 2017/2/16.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Meta {

    boolean pKey() default false;

    boolean nullable() default true;

    String generator() default "";

    String column() default "";

    String defaultValue() default "";

    String defaultCheck() default "";

    String format() default "";

}
