package notes.mvc.service.animal.impl;

import lombok.extern.slf4j.Slf4j;
import notes.mvc.service.animal.Fly;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

/**
 * Description：方法注入
 * 即使是抽象类，也可以成为Bean
 *
 * @author zzy520git
 * @date 2019/12/23 18:28
 * @ see
 * @since
 */
@Slf4j
@Component
public abstract class WhiteDog implements Fly {

    /**
     * lookup方法(无参)注入，协调单例Bean和原型Bean
     * 原理是jdk动态代理或cglib字节码增强
     * <p>
     * blackBird是一个原型Bean
     * 每次请求该方法都是一个新的Bean
     *
     * @return 依赖的原型Bean
     */
    @Lookup("blackBird")
    public abstract Fly getFly();

    @Override
    public void fly() {
        Fly bird = getFly();
        bird.fly();
        log.warn("我是WhiteDog-我也会飞");
    }
}
