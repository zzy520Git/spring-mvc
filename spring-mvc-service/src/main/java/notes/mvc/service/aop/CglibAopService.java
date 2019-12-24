package notes.mvc.service.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Description：
 *
 * @author zzy520git
 * @date 2019/12/24 10:04
 * @ see
 * @since
 */
@Slf4j
@Service("cglibAopService")
public class CglibAopService {

    /**
     * before增强处理
     */
    public void before() {
        log.warn("CglibAopService.before()开始执行");
    }

    /**
     * afterReturning增强处理
     *
     * @param name
     * @return
     */
    public Integer afterReturning(String name) {
        log.warn("CglibAopService.afterReturning()开始执行name={}", name);
        return 18;
    }

    /**
     * AfterThrowing增强处理
     *
     * @return
     */
    public int afterThrowing() {
        log.warn("CglibAopService.afterThrowing()开始执行");
        Integer age = null;
        return age.intValue();
    }

    /**
     * after增强处理
     *
     * @return
     */
    public void after() {
        log.warn("CglibAopService.after()开始执行");
    }

    /**
     * around增强处理
     *
     * @return
     */
    public String around(String alias) {
        log.warn("CglibAopService.around()开始执行");
        return alias;
    }
}
