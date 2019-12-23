package notes.mvc.service.factory;

import notes.mvc.domain.Student;
import org.springframework.beans.factory.FactoryBean;

/**
 * Description：工厂Bean
 *
 * @author zzy520git
 * @date 2019/12/23 18:11
 * @ see
 * @since
 */
public class StudentFactoryBean implements FactoryBean<Student> {
    @Override
    public Student getObject() throws Exception {
        return new Student(1, 123, "StudentFactoryBean");
    }

    @Override
    public Class<?> getObjectType() {
        return Student.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
