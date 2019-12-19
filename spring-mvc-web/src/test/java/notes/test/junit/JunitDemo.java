package notes.test.junit;

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
public class JunitDemo {
    @Test
    public void demoRead() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-config.xml");
        StudentService studentService = context.getBean(StudentService.class);
        studentService.doHomeWork();
    }
}
