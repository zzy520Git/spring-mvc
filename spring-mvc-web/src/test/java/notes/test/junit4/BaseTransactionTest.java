package notes.test.junit4;

import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Description：测试用例，事务基类，一般不用
 *
 * @author zzy-PC
 * @date 2019/3/10 18:57
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-config.xml"})
@Transactional(transactionManager = "transactionManager")
//该注解的作用是（如果value=true），则操作完成后，自动回滚数据库，防止污染线上数据库
@Rollback(value = false)
public class BaseTransactionTest {
}
