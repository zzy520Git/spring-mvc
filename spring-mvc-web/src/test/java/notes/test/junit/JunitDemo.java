package notes.test.junit;

import lombok.extern.slf4j.Slf4j;
import notes.mvc.domain.Student;
import notes.mvc.service.animal.Fly;
import notes.mvc.service.animal.impl.WhiteDog;
import notes.mvc.service.school.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description：
 *
 * @author zzy520git
 * @date 2019/3/10 15:47
 */
@Slf4j
public class JunitDemo {
    @Test
    public void demoRead() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-config.xml");
        StudentService studentService = context.getBean(StudentService.class);
        studentService.doHomeWork();

        Student jackMa = context.getBean("jackMa", Student.class);
        log.warn("jackMa={}", jackMa);

        WhiteDog whiteDog = context.getBean(WhiteDog.class);
        whiteDog.fly();
        whiteDog.fly();

        //原型模式
        Fly fly1 = context.getBean("blackBird", Fly.class);
        Fly fly2 = context.getBean("blackBird", Fly.class);
        log.warn("fly1 == fly2:" + (fly1 == fly2));

        Thread.sleep(1000);
    }
}
