package notes.mvc.service.school.impl;

import lombok.extern.slf4j.Slf4j;
import notes.mvc.service.school.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

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
    @Autowired
    private TransactionTemplate transactionTemplate;

    @Override
    public void doHomeWork() {
        log.warn("studentService开始写家庭作业");
    }

    public String templateSql() {
        //建议使用lambda表达式，而不是匿名内部类
        return transactionTemplate.execute(transactionStatus -> {
            try {
                //todo 数据库操作
                return "success";
            } catch (Exception e) {
                transactionStatus.setRollbackOnly();
                log.error("事务回滚啦：", e);
            }
            return "fail";
        });
    }

    @Transactional(rollbackFor = Exception.class)
    public void testTransaction() {
        //todo 数据库操作

    }
}
