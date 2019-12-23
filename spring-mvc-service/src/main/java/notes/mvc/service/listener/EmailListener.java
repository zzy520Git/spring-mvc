package notes.mvc.service.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Description：
 * 配置bean后自动监听容器事件
 *
 * @author zzy520git
 * @date 2019/12/23 15:26
 * @ see
 * @since
 */
@Slf4j
@Component
public class EmailListener implements ApplicationListener<EmailEvent> {
    /**
     * spring发布EmailEvent事件能够监听到
     * @param event
     */
    @Override
    public void onApplicationEvent(EmailEvent event) {
        //处理线程和发布事件的线程是同一个，不是异步的哟
        log.warn("线程={}消费了容器EmailEvent事件-source={}", Thread.currentThread().getName(), event.getSource());
    }
}
