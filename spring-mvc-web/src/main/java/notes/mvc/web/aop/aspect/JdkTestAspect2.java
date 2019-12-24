package notes.mvc.web.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * Description：
 * 1.切面-Aspect
 * 2.切入点-JointPoint
 * 3.增强-Advice
 * 4.切点-PointCut
 *
 * @author zzy520git
 * @date 2019/12/24 10:17
 * @ see
 * @since
 */
@Slf4j
@Aspect
@Order(Ordered.LOWEST_PRECEDENCE)   //使用默认值更常用
public class JdkTestAspect2 {

    /**
     * before增强无法访问方法的入参和返回值
     * jp只能是第一个参数，除了around增强，jp只能访问方法或代理对象的一些信息
     */
    @Before("JdkTestAspect1.jdkAopPoint()")
    public void beforeAdvice(JoinPoint jp) {
        //只获取方法名
        log.info("beforeAdvice2，method={}", jp.getSignature().getName());
    }

    /**
     * AfterReturning增强可以访问返回值，但不能修改返回值
     * pointcut属性等同于value属性
     * returning属性定义的形参类型，还能限制切入点的返回值类型，返回值不符合的不会切入
     * todo:只有切入点不抛异常，即成功执行并返回，才能织入
     */
    @AfterReturning(pointcut = "JdkTestAspect1.jdkAopPoint()", returning = "rvt")
    public void afterReturningAdvice(JoinPoint jp, Integer rvt) {
        log.info("afterReturningAdvice2，rvt={}", rvt);
        rvt = 100;
    }

    /**
     * AfterThrowing增强可以访问连接点抛出的异常，只能访问不能处理
     * pointcut属性等同于value属性
     * throwing属性定义的形参类型，还能限制切入点的抛出的异常类型，异常不符合的不会切入
     * todo:此时不会切入抛空指针异常的方法
     */
    @AfterThrowing(pointcut = "JdkTestAspect1.jdkAopPoint()", throwing = "ex")
    public void afterThrowingAdvice(IllegalArgumentException ex) {
        log.info("afterThrowingAdvice", ex);
    }

    /**
     * After增强
     * todo:无论切入点抛异常还是成功执行并返回，都能织入
     */
    @After("JdkTestAspect1.jdkAopPoint()")
    public void afterAdvice(JoinPoint jp) {
        //
        log.info("afterAdvice2，target.class=【{}】, this.class=【{}】", jp.getTarget().getClass().getSimpleName(),
                jp.getThis().getClass().getName());
    }

    /**
     * Around增强
     * 可以改变切入点方法的入参和返回值，甚至能控制目标方法是否执行
     * Object[] jp.getArgs()：返回目标方法的入参(实参)
     * Signature jp.getSignature()：返回目标方法相关信息
     * Object jp.getTarget()：返回目标对象
     * Object jp.getThis()：返回目标对象的代理对象
     */
    @Around("JdkTestAspect1.jdkAopPoint()")
    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
        log.info("aroundAdvice2.start");
        Object rvt = pjp.proceed();
        log.info("aroundAdvice2.end");
        if (rvt != null && rvt instanceof String) {
            rvt += " 加入around增强处理";
        }
        return rvt;
    }
}