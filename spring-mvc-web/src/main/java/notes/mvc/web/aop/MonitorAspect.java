package notes.mvc.web.aop;

import lombok.extern.slf4j.Slf4j;
import notes.mvc.common.annotation.monitor.XMonitor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.lang.reflect.Method;

/**
 * Description：
 *
 * @author zzy520git
 * @date 2019/7/8 9:18
 * @ see
 * @since
 */
@Aspect
@Order(value = Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class MonitorAspect {

    @Pointcut("@annotation(notes.mvc.common.annotation.monitor.XMonitor)")
    public void monitorPoint() {
    }

    //调用该方法时：配置文件中proxy-target-class="true"必须要设置
    private Method getMethod1(JoinPoint jp) {
        try {
            MethodSignature msig = (MethodSignature)jp.getSignature();
            return msig.getMethod();
        } catch (Exception e) {
            log.error("MonitorAspect.getMethod1 error", e);
        }
        return null;
    }
    //调用该方法时：配置文件中proxy-target-class可省略或者为false
    private Method getMethod(JoinPoint jp) throws Exception {
        try {
            MethodSignature msig = (MethodSignature)jp.getSignature();
            Method realMethod = jp.getTarget().getClass().getDeclaredMethod(msig.getName(),
                    msig.getMethod().getParameterTypes()) ;
            return realMethod;
        } catch (Exception e) {
            log.error("MonitorAspect.getMethod error", e);
        }
        return null;
    }

    @Around("monitorPoint()")
    public Object execXMonitor(ProceedingJoinPoint jp) throws Throwable {
        Method method = this.getMethod(jp);
        if (method != null) {
            XMonitor monitor = method.getAnnotation(XMonitor.class) ;
        }
        return jp.proceed();
    }

    //日志搜不出点.  不要输出umpKey到日志
//    String umpKey = jp.getTarget().getClass().getName() + "." + jp.getSignature().getName();

//    Class clazz = method.getReturnType();
//            if(rethrow || (clazz != null && clazz.isPrimitive())) {
//        throw e;
//    }


}
