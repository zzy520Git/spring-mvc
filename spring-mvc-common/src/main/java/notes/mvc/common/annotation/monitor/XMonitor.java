package notes.mvc.common.annotation.monitor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description：
 * 注解监控
 * @author
 * @date 2018/8/3 14:10
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface XMonitor {
    String value() default "";
    boolean rethrow() default false;
}
