package notes.mvc.web.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * Description：
 *
 * @author zzy520git
 * @date 2019/12/20 12:59
 * @ see
 * @since
 */
@Aspect
@Order(value = Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class TraceAspect {
    //RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
    //Thread.
}
