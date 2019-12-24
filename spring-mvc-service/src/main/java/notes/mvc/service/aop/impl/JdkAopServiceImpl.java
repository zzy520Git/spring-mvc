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
    @Override
    public Integer doAop(String name) {
        log.warn("JdkAopServiceImpl.doAop()开始执行name={}", name);
        return 18;
    }
}
