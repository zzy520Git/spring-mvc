package notes.mvc.service.animal.impl;

import lombok.extern.slf4j.Slf4j;
import notes.mvc.service.animal.Fly;
import org.springframework.stereotype.Component;

/**
 * Description：
 *
 * @author zzy520git
 * @date 2019/12/23 18:24
 * @ see
 * @since
 */
@Slf4j
@Component("whiteBird")
public class WhiteBird implements Fly {
    @Override
    public void fly() {
        log.warn("我是一只单例企鹅^_^，addr={}", this.hashCode());
    }
}
