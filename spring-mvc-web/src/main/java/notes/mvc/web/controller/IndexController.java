package notes.mvc.web.controller;

import notes.mvc.common.annotation.monitor.XMonitor;
import notes.mvc.common.response.Code;
import notes.mvc.common.response.ResponseResult;
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
@Controller
public class IndexController {
    @Autowired
    private StudentService studentService;

    @ResponseBody
    @RequestMapping("/index")
    @XMonitor
    public ResponseResult index() {
        studentService.doHomeWork();
        return ResponseResult.successResult(Code.CommonCode.SUCCESS);
    }
}
