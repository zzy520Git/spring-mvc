package notes.test.example;

import notes.mvc.service.school.StudentService;
import notes.test.junit4.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Description：
 *
 * @author zzy-PC
 * @date 2019/3/10 18:36
 */
public class StudentServiceTest extends BaseTest {
    @Autowired
    private StudentService studentService;

    @Test
    public void demoRead() {
        studentService.doHomeWork();
    }
}
