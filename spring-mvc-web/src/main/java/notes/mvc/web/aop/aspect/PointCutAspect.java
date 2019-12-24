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
     * args() 无参
     * args(*) 一个参数
     * args(..) 0个或任意个参数
     *
     * 切入点表达式：
     * within(notes.mvc.service.aop.*)  该包下的所有方法连接点
     * within(notes.mvc.service.aop..*) 该包及其子包的所有方法连接点
     *
     * this(notes.mvc.service.aop.JdkAopService)    代理对象是该类或接口实例的所有方法
     * target(notes.mvc.service.aop.JdkAopService)  目标对象该类或接口实例的所有方法
     *
     * args(notes.mvc.service.aop.JdkAopService)    实参(注意不是方法定义)传入的是JdkAopService类型的方法
     *
     * bean(*AopService)    匹配所有id以AopService结尾的Bean里面的方法
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
