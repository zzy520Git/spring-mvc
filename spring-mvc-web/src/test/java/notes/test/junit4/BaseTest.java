package notes.test.junit4;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Description：测试用例基类，更为常用
 *
 * @author zzy-PC
 * @date 2019/3/10 18:29
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-config.xml"})
public class BaseTest {
}
