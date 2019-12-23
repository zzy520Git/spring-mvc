package notes.mvc.service.postprocessor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * Description：容器后处理器
 *
 * @author zzy520git
 * @date 2019/12/23 21:05
 * @ see
 * @since
 */
@Component
@Slf4j
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        //容器后处理器，在Bean后处理器之前运行
        log.warn("BeanFactoryPostProcessor容器后处理器");
    }
}
