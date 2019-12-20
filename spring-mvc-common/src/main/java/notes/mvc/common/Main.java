package notes.mvc.common;

import notes.mvc.common.response.ResponseResult;
import notes.mvc.common.util.JsonUtil;

/**
 * Description：
 *
 * @author zzy520git
 * @date 2019/12/20 10:00
 * @ see
 * @since
 */
public class Main {
    public static void main(String[] args) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.put("errCode", "happy new year!");
        System.out.println(JsonUtil.toJSONView(responseResult));
    }
}
