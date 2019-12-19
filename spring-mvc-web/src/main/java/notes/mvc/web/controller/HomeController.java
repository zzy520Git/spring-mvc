package notes.mvc.web.controller;

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
@RestController
@RequestMapping("/home")
public class HomeController {

    @RequestMapping("/t")
    public Object home(HttpServletRequest request, HttpServletResponse response) {
        return "home";
    }
}
