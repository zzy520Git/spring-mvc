package notes.mvc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * Description:
 *
 * @author zhouzhongyi
 * @date 2020/12/5
 */
@ToString
public class PeriodBean implements DisposableBean, InitializingBean, ApplicationContextAware/*, BeanPostProcessor */{
    private static int times = 0;
    @Resource
    private Student lisi;
    @Autowired
    @Qualifier("jackMa")
    private Student jackMa;

    private int age;

    public PeriodBean() {
        System.out.println("PeriodBean new" + (lisi !=null) + (jackMa != null));

    }

    public void setAge(int age) {
        System.out.println("PeriodBean setAge " + (lisi !=null) + (jackMa != null));
        this.age = age;
    }

    private void init() {
        System.out.println("PeriodBean.init lisi!=null,jack!=null,age=" + age + (lisi !=null) + (jackMa != null));
        System.out.println("PeriodBean init");
    }

    private void dest() {
        System.out.println("PeriodBean dest");
    }

    @PostConstruct
    private void post() {
        System.out.println("PeriodBean.PostConstruct lisi!=null,jack!=null,age=" + age + (lisi !=null) + (jackMa != null));
        System.out.println("PeriodBean PostConstruct");
    }

    @PreDestroy
    private void pre() {
        System.out.println("PeriodBean PreDestroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("PeriodBean.afterPropertiesSet lisi!=null,jack!=null,age=" + age + (lisi !=null) + (jackMa != null));
        System.out.println("PeriodBean InitializingBean.afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("PeriodBean DisposableBean.destroy");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        System.out.println("PeriodBean setApplicationContext");
    }

    //@Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (times++ < 1) {
            System.out.println("PeriodBean postProcessBeforeInitialization");
        }
        return bean;
    }

    //@Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (times++ <= 1) {
            System.out.println("PeriodBean postProcessAfterInitialization");
        }
        return bean;
    }
}
