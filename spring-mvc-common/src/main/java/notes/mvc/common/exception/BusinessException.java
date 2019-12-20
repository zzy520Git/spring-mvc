package notes.mvc.common.exception;

import notes.mvc.common.response.Code;

public class BusinessException extends RuntimeException {
    public BusinessException() {
        super("业务异常");
    }

    public BusinessException(String msg) {
        super(msg);
    }

    public BusinessException(String code, String desc) {
        super(String.format("业务逻辑异常；错误码:[%s], 错误信息:[%s].", code, desc));
    }

    public static BusinessException paramException() {
        return new BusinessException(Code.CheckCode.PARAM_ERROR.getCode(), Code.CheckCode.PARAM_ERROR.getDesc());
    }

    public static BusinessException systemException() {
        return new BusinessException(Code.CommonCode.Failure.getCode(), Code.CommonCode.Failure.getDesc());
    }
}
