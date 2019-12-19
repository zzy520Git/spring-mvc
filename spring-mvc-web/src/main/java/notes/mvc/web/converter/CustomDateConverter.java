package notes.mvc.web.converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Description:
 * 自定义参数绑定
 *
 * @author zzy520git
 * @date 2018/7/26 22:41
 */
@Slf4j
public class CustomDateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        //实现将日期串转成日期类型(格式是yyyy-MM-dd HH:mm:ss)
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return simpleDateFormat.parse(s);
        } catch (Exception e) {
            log.error("CustomDateConverter error s={}", s, e);
        }
        return null;
    }
}
