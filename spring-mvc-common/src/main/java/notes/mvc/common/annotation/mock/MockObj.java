package notes.mvc.common.annotation.mock;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description：
 *
 * @author zzy520git
 * @date 2019/8/8 14:19
 * @ see
 * @since
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface MockObj {
    Class<?> value();
}
