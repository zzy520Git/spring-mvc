package notes.mvc.web.controller;

import lombok.extern.slf4j.Slf4j;
import notes.mvc.common.annotation.monitor.XMonitor;
import notes.mvc.common.response.Code;
import notes.mvc.common.response.ResponseResult;
import notes.mvc.service.aop.CglibAopService;
import notes.mvc.service.school.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description：
 *
 * @author zzy520git
 * @date 2019/12/19 15:55
 * @ see
 * @since
 */
@Slf4j
@Controller
public class IndexController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private CglibAopService cglibAopService;

    @ResponseBody
    @RequestMapping("/index")
    @XMonitor
    public ResponseResult index() {
        studentService.doHomeWork();
        return ResponseResult.successResult(Code.CommonCode.SUCCESS);
    }

    @ResponseBody
    @RequestMapping("/aop")
    public ResponseResult aop() {
        cglibAopService.before();
        Integer age = cglibAopService.afterReturning("jack");
        try {
            log.warn("上学前年龄age={}", age);
            age = cglibAopService.afterThrowing();
            log.warn("上学后年龄age={}", age);
        } catch (Exception e) {
            log.error("异常了e-msg={}", e.getMessage());
        }
        cglibAopService.after();
        String name = cglibAopService.around("zzy520git");
        log.warn("realname={}", name);
        return ResponseResult.successResult(Code.CommonCode.SUCCESS);
    }
}
