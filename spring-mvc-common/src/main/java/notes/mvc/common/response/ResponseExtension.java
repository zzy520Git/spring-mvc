package notes.mvc.common.response;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Description：
 *
 * @author zzy520git
 * @date 2019/12/20 9:53
 * @ see
 * @since
 */
@Getter
public class ResponseExtension {
    /**
     * 扩展信息
     */
    private Map<String, Object> ext = new HashMap<>(0);

    public void put(String extKey, Object extValue) {
        ext.put(extKey, extValue);
    }

}
