package notes.test.junit;

import lombok.extern.slf4j.Slf4j;
import notes.mvc.domain.Student;
import notes.mvc.service.listener.EmailEvent;
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

        EmailEvent emailEvent = new EmailEvent("test container event");
        context.publishEvent(emailEvent);
        Student jackMa = context.getBean("jackMa", Student.class);
        log.warn("jackMa={}", jackMa);

        Thread.sleep(1000);
    }
}
