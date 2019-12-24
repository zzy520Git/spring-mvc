package notes.mvc.web.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Description：
 *
 * @author zzy520git
 * @date 2019/12/24 16:10
 * @ see
 * @since
 */
@Slf4j
@Aspect
public class PointCutAspect {
    /**
     * args会限制目标方法的入参类型，能够以一种简单的方式获取入参
     *
     * 此方法会匹配入参是一个或多个形参的目标方法织入，并且第一个参数类型必须是String
     *
     * @param jp
     * @param food
     */
    @Before("execution(* notes.mvc.service.aop.JdkAopService.doPointCut(..)) && args(food, ..)")
    public void beforeAdvice(JoinPoint jp, String food) {
        //只获取方法名
        log.info("beforeAdvice，food={}, method={}", food, jp.getSignature().getName());
    }
}
