package notes.mvc.service.postprocessor;

import lombok.extern.slf4j.Slf4j;
import notes.mvc.service.school.StudentService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * Description：
 * Bean后处理器
 *
 * @author zzy520git
 * @date 2019/12/23 20:57
 * @ see
 * @since
 */
@Slf4j
@Component
public class StudentServiceBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof StudentService) {
            log.warn("BeanPostProcessor.postProcessBeforeInitialization");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof StudentService) {
            log.warn("BeanPostProcessor.postProcessAfterInitialization");
        }
        return bean;
    }
}
