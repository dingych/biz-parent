package cn.waynechu.webcommon.util;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhuwei
 * @date 2019/3/29 14:45
 */
@UtilityClass
public class WebUtil {

    public static String getReqParam(String key, HttpServletRequest request) {
        // 1. parameter
        String parameter = request.getParameter(key);
        if (StringUtils.isEmpty(parameter)) {
            // 2. header
            parameter = request.getHeader(key);
        }
        return parameter;
    }
}
