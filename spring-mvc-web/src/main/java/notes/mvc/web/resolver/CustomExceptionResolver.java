package notes.mvc.web.resolver;

import lombok.extern.slf4j.Slf4j;
import notes.mvc.common.ResponseResult;
import notes.mvc.common.util.JsonUtil;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Description：
 * 统一异常处理器
 *
 * @author zzy520git
 * @date 2018/8/3 14:22
 */
@Slf4j
public class CustomExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        if (handler != null && handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            log.error("HandlerExceptionResolver print error. beanName=【{}】 beanMethod=【{}】",
                    handlerMethod.getBeanType().getName(), handlerMethod.getMethod().getName(), ex);
        } else {
            log.error("HandlerExceptionResolver print error. handler=【{}】", handler, ex);
        }
        if (isAjaxRequest(request)) {
            PrintWriter writer = null;
            try {
                response.setContentType("application/json; charset=utf-8");
                response.setCharacterEncoding("utf-8");
                writer = response.getWriter();
                writer.print(JsonUtil.toJSONString(new ResponseResult()));
            } catch (Exception e) {
                log.error("CustomExceptionResolver: response.getWriter() error", e);
            } finally {
                if(null != writer){
                    writer.close();
                }
            }
            return null;
        } else {
            //跳转到错误页面
            return new ModelAndView("index.jsp");
        }
    }

    /**
     * 判断是否为ajax请求
     *
     * @param request 请求
     * @return true 为ajax请求
     */
    private boolean isAjaxRequest(HttpServletRequest request) {
        boolean isAjaxReuest = false;
        if (request.getHeader("X-Requested-With") != null && "XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
            isAjaxReuest = true;
        }
        return isAjaxReuest;
    }
}
