package notes.mvc.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * Description：
 *
 * @author zzy520git
 * @date 2019/10/31 11:27
 * @ see
 * @since
 */
@Slf4j
public class JsonUtil {
    public static String toJSONString(Object object) {
        try {
            return JSON.toJSONString(object);
        } catch (Exception e) {
            log.error("toJSONString解析:{} json出错:{}", object, e);
        }
        return null;
    }

    public static String toJSONView(Object object) {
        try {
            return JSON.toJSONString(object, SerializerFeature.WriteMapNullValue,
                    SerializerFeature.WriteNonStringKeyAsString);
        } catch (Exception e) {
            log.error("toJSONView解析:{} json出错:", object, e);
        }
        return null;
    }

    public static String toFullJSONString(Object object) {
        try {
            return JSON.toJSONString(object, SerializerFeature.WriteMapNullValue);
        } catch (Exception e) {
            log.error("toFullJSONString解析:{} json出错:", object, e);
        }
        return null;
    }

    public static <T> T parseObject(String text, Class<T> clazz) {
        try {
            return JSON.parseObject(text, clazz);
        } catch (Exception e) {
            log.error("解析字符串:{} json出错:{}", text, e);
        }
        return null;
    }

    public static JSONArray parseArray(String jsonStr) {
        try {
            return JSON.parseArray(jsonStr);
        } catch (Exception e) {
            log.error("解析字符串:{} json出错:{}", jsonStr, e);
        }
        return null;
    }

    public static <T> List<T> parseArray(String text, Class<T> clazz) {

        try {
            return JSON.parseArray(text, clazz);
        } catch (Exception e) {
            log.error("解析字符串:{} json出错:{}", text, e);
        }
        return null;
    }

    public static JSONObject parseObject(String jsonText) {
        try {
            return JSON.parseObject(jsonText);
        } catch (Exception e) {
            log.error("解析字符串:{} json出错:{}", jsonText, e);
        }
        return null;
    }

    //T可以为List<K>
    public static <T> T parseObject(String text, TypeReference<T> type) {

        try {
            return JSON.parseObject(text, type);
        } catch (Exception e) {
            log.error("解析字符串:{} json出错:{}", text, e);
        }
        return null;
    }

    public static Object parse(String text) {
        try {
            return JSON.parse(text);
        } catch (Exception e) {
            log.error("解析字符串:{} json出错:{}", text, e);
        }
        return null;
    }


}
