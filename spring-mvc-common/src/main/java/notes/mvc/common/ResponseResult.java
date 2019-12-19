package notes.mvc.common;

import lombok.Data;

/**
 * Description:
 * Ajax返回值响应ResponseBody
 * @author zzy520git
 * Date: 2018/7/29 9:06
 */
@Data
public class ResponseResult<T> {


    private String code ;

    private String desc ;

    private T value ;

    private boolean success ;

}
