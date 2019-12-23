package notes.mvc.service.listener;

import org.springframework.context.ApplicationEvent;

/**
 * Description：测试容器事件
 *
 * @author zzy520git
 * @date 2019/12/23 15:28
 * @ see
 * @since
 */
public class EmailEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public EmailEvent(Object source) {
        super(source);
    }
}
