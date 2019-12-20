package notes.mvc.web.controller;

import notes.mvc.common.response.ResponseResult;
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

    @ResponseBody
    @RequestMapping("/index")
    public ResponseResult index() {
        return new ResponseResult();
    }
}
