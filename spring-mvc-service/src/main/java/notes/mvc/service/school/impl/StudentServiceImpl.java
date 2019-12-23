package notes.mvc.service.school.impl;

import lombok.extern.slf4j.Slf4j;
import notes.mvc.common.annotation.monitor.XMonitor;
import notes.mvc.service.school.StudentService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
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
public class StudentServiceImpl implements StudentService, ApplicationContextAware {
    @Autowired
    private TransactionTemplate transactionTemplate;

    /**
     * 获取spring容器
     */
    private ApplicationContext ctx;

    @Override
    @XMonitor
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

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;
    }
}
