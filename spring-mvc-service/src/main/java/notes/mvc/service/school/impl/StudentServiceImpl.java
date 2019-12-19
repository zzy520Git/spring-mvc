package notes.mvc.service.school.impl;

import lombok.extern.slf4j.Slf4j;
import notes.mvc.service.school.StudentService;
import org.springframework.stereotype.Service;

/**
 * Description：
 *
 * @author zzy520git
 * @date 2019/12/19 19:53
 * @ see
 * @since
 */
@Slf4j
@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Override
    public void doHomeWork() {
        log.warn("studentService开始写家庭作业");
    }
}
