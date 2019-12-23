package notes.mvc.service;

import lombok.extern.slf4j.Slf4j;
import notes.mvc.domain.Student;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Description：注解定义Bean
 *
 * @author zzy520git
 * @Import 向当前配置类导入其他配置类
 * @DependsOn 初始化对应Bean之前先初始化指定的Bean
 * @ImportResource 如果以java配置类为主，则此注解引入xml配置
 * @date 2019/12/23 17:30
 * @ see
 * @since
 */
//@Import({BeanConfig.class})
//@ImportResource("classpath:/beans.xml")
@Component //配置成Bean即可主xml方式解析此配置类
@Configuration
@Slf4j
public class BeanConfig {
    //@DependsOn
    @Lazy
    @Scope("singleton")
    @Bean(name = "zhangsan")
    public Student zhangsan() {
        return new Student();
    }

    public static void main(String[] args) {
        //此种方式不用@Component
        AnnotationConfigApplicationContext atx = new AnnotationConfigApplicationContext(BeanConfig.class);
        //可以注册其他配置类
        //atx.register(BeanConfig1.class);
        Student student = atx.getBean("zhangsan", Student.class);
        log.warn(student.toString());
    }
}
