package notes.mvc.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Description：
 *
 * @author zzy520git
 * @date 2019/12/19 17:29
 * @ see
 * @since
 */
@Data
public class Student {


    public Student() {

    }
    /**
     * 测试spring构造注入
     */
    public Student(long id, Integer age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }


    private long id;
    private Integer age;
    private String name;
    private String username;
    private String password;

    private Date birthday;

    private List<Object> schools;
    private Map<String, Object> scores;
    private Properties properties;
}
