package notes.mvc.common.response;

import lombok.Getter;

/**
 * Description：
 *
 * @author zzy520git
 * @date 2019/12/20 10:17
 * @ see
 * @since
 */
public class Code {
    @Getter
    public enum CommonCode implements ResultCode {
        /**
         * 操作失败
         */
        Failure("0", "操作失败"),
        SUCCESS("1", "操作成功"),
        ;

        /**
         * code码
         */
        private String code;
        /**
         * code描述
         */
        private String desc;
        CommonCode(String code, String desc) {
            this.code = code;
            this.desc = desc;
        }
    }

    @Getter
    public enum CheckCode implements ResultCode {
        /**
         * 参数校验
         */
        PARAM_ERROR("400", "参数错误"),
        PARAM_NULL("401", "参数为空"),
        STATUS_ERROR("403", "状态校验不通过"),
        ;

        /**
         * code码
         */
        private String code;
        /**
         * code描述
         */
        private String desc;
        CheckCode(String code, String desc) {
            this.code = code;
            this.desc = desc;
        }
    }

    @Getter
    public enum SystemCode implements ResultCode {
        /**
         * 本系统内部异常
         */
        NULL_POINTER("500", "可能的空指针"),
        ;

        /**
         * code码
         */
        private String code;
        /**
         * code描述
         */
        private String desc;
        SystemCode(String code, String desc) {
            this.code = code;
            this.desc = desc;
        }
    }

    @Getter
    public enum RpcCode implements ResultCode {
        /**
         * 远程调用异常
         */
        NoAliveProvider("600", "无服务提供者"),
        ;

        /**
         * code码
         */
        private String code;
        /**
         * code描述
         */
        private String desc;
        RpcCode(String code, String desc) {
            this.code = code;
            this.desc = desc;
        }
    }

    @Getter
    public enum CustomCode implements ResultCode {
        /**
         * 自定义业务异常
         */
        UNKNOW("1000", "未知"),
        ;

        /**
         * code码
         */
        private String code;
        /**
         * code描述
         */
        private String desc;
        CustomCode(String code, String desc) {
            this.code = code;
            this.desc = desc;
        }
    }
}
