package notes.mvc.common.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Description:
 * Ajax返回值响应ResponseBody
 *
 * @author zzy520git
 * Date: 2018/7/29 9:06
 */
@Getter
@Setter
@ToString
public class ResponseResult<T> extends ResponseExtension {
    /**
     * 是否成功
     */
    private boolean success;
    /**
     * 业务code
     */
    private String code;
    /**
     * 提示信息
     */
    private String msg;
    /**
     * 返回实体
     */
    private T data;

    public static <T> ResponseResult<T> successResult(ResultCode code) {
        return successResult(code,null);
    }

    public static <T> ResponseResult<T> successResult(ResultCode code, T data) {
        ResponseResult<T> result = new ResponseResult<>();
        result.setSuccess(true);
        result.setCode(code.getCode());
        result.setMsg(code.getDesc());
        result.setData(data);
        return result;
    }

    public static <T> ResponseResult<T> errorCodeMsg(ResultCode code, String msg) {
        return errorCodeMsgData(code, msg,null);
    }

    public static <T> ResponseResult<T> errorCodeMsgData(ResultCode code, String msg, T data) {
        ResponseResult<T> result = new ResponseResult<>();
        result.setSuccess(false);
        result.setCode(code.getCode());
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

}
