package notes.mvc.web.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.lang.reflect.Method;

/**
 * Description：
 *
 * @author zhouzhongyi1
 * @date 2019/7/8 9:18
 * @ see
 * @since
 */
@Aspect
@Order(value = Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class MonitorAspect {


    private Method getMethod(JoinPoint jp) {
        try {
            MethodSignature msig = (MethodSignature)jp.getSignature();
            Method realMethod = jp.getTarget().getClass().getDeclaredMethod(msig.getName(),
                    msig.getMethod().getParameterTypes()) ;
            return realMethod;
        } catch (Throwable e) {
            log.error("{}", e);
        }
        return null;
    }


}
