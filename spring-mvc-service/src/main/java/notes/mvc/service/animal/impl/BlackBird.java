package notes.mvc.service.animal.impl;

import lombok.extern.slf4j.Slf4j;
import notes.mvc.service.animal.Fly;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Description：
 *
 * @author zzy520git
 * @date 2019/12/23 18:45
 * @ see
 * @since
 */
@Slf4j
@Service("blackBird")
@Scope("prototype")
public class BlackBird implements Fly {
    @Override
    public void fly() {
        log.warn("我是原型Bean=BlackBird,addr={}", this.hashCode());
    }

}
