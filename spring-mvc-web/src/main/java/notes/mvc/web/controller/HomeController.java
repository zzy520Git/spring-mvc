package notes.mvc.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description：
 *
 * @author zzy520git
 * @date 2019/12/19 15:56
 * @ see
 * @since
 */
@Slf4j
@RestController
@RequestMapping("/home")
public class HomeController {

    /**
     *
     java.lang.Thread.run
     org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run
     java.util.concurrent.ThreadPoolExecutor$Worker.run
     java.util.concurrent.ThreadPoolExecutor.runWorker
     org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.run
     org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.doRun
     org.apache.coyote.AbstractProtocol$AbstractConnectionHandler.process
     org.apache.coyote.http11.AbstractHttp11Processor.process
     org.apache.catalina.connector.CoyoteAdapter.service
     org.apache.catalina.core.StandardEngineValve.invoke
     org.apache.catalina.valves.AbstractAccessLogValve.invoke
     org.apache.catalina.valves.ErrorReportValve.invoke
     org.apache.catalina.core.StandardHostValve.invoke
     org.apache.catalina.authenticator.AuthenticatorBase.invoke
     org.apache.catalina.core.StandardContextValve.invoke
     org.apache.catalina.core.StandardWrapperValve.invoke
     org.apache.catalina.core.ApplicationFilterChain.doFilter
     org.apache.catalina.core.ApplicationFilterChain.internalDoFilter
     * @see org.springframework.web.filter.OncePerRequestFilter#doFilter
     * @see org.springframework.web.filter.CharacterEncodingFilter#doFilterInternal
     org.apache.catalina.core.ApplicationFilterChain.doFilter
     org.apache.catalina.core.ApplicationFilterChain.internalDoFilter
     org.apache.tomcat.websocket.server.WsFilter.doFilter
     org.apache.catalina.core.ApplicationFilterChain.doFilter
     org.apache.catalina.core.ApplicationFilterChain.internalDoFilter
     * @see javax.servlet.http.HttpServlet#service
     * @see org.springframework.web.servlet.FrameworkServlet#service
     * @see javax.servlet.http.HttpServlet#service
     * @see org.springframework.web.servlet.FrameworkServlet#doGet
     * @see org.springframework.web.servlet.FrameworkServlet#processRequest
     * @see org.springframework.web.servlet.DispatcherServlet#doService
     * @see org.springframework.web.servlet.DispatcherServlet#doDispatch
     * @see org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter#handle
     * @see org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter#handleInternal
     * @see org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter#invokeHandlerMethod
     * @see org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod#invokeAndHandle
     * @see org.springframework.web.method.support.InvocableHandlerMethod#invokeForRequest
     * @see org.springframework.web.method.support.InvocableHandlerMethod#doInvoke
     java.lang.reflect.Method.invoke
     sun.reflect.DelegatingMethodAccessorImpl.invoke
     sun.reflect.NativeMethodAccessorImpl.invoke
     sun.reflect.NativeMethodAccessorImpl.invoke0
     notes.mvc.web.controller.HomeController.home
     */
    @RequestMapping("/t")
    public Object home(HttpServletRequest request, HttpServletResponse response) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (int i=stackTrace.length-1 ; i > 0 ; i--) {
            StackTraceElement e = stackTrace[i];
            log.warn(e.getClassName() + "." + e.getMethodName());
        }
        return "home";
    }
}
