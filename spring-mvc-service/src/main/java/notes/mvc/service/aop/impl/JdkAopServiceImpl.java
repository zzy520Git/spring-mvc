package notes.mvc.service.aop.impl;

import lombok.extern.slf4j.Slf4j;
import notes.mvc.service.aop.JdkAopService;
import org.springframework.stereotype.Service;

/**
 * Description：
 *
 * @author zzy520git
 * @date 2019/12/24 10:03
 * @ see
 * @since
 */
@Slf4j
@Service("jdkAopService")
public class JdkAopServiceImpl implements JdkAopService {
    /**
     * 执行顺序：(换句话说，order值越小，优先级越高，代码越在外面包裹，target前面先执行，target后面后执行)
     * <p>
     * JdkTestAspect1.aroundAdvice start 优先级更高优先执行（但是target和this以及method都不准）
     * JdkTestAspect1.beforeAdvice 优先级更高优先织入（但是target和this以及method都不准）
     * JdkTestAspect2.aroundAdvice start
     * JdkTestAspect2.beforeAdvice
     * -- target --
     * JdkTestAspect2.aroundAdvice end
     * JdkTestAspect2.afterAdvice
     * JdkTestAspect2.afterReturningAdvice
     * JdkTestAspect1.aroundAdvice end 优先级更高优先执行（但是target和this以及method都不准）
     * JdkTestAspect1.afterAdvice 优先级更高优先织入（但是target和this以及method都不准）
     * JdkTestAspect1.afterReturningAdvice 优先级更高优先织入（但是target和this以及method都不准）
     *
     * @param name
     * @return
     */
    @Override
    public Integer doAop(String name) {
        log.warn("JdkAopServiceImpl.doAop()开始执行name={}", name);
        return 18;
    }

    /**
     * 测试切点
     *
     * @param alias
     * @return
     */
    @Override
    public String doPointCut(String alias) {
        log.warn("JdkAopServiceImpl.doPointCut()开始执行alias={}", alias);
        return "money";
    }
}
