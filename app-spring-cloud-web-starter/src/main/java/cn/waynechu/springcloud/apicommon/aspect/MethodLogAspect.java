package cn.waynechu.springcloud.apicommon.aspect;

import cn.waynechu.spirngcloud.common.aspect.AbstractMethodLogAspect;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 方法切面
 * 只要在方法上加上
 *
 * @author zhuwei
 * @date 2019/3/29 17:10
 */
@Aspect
@Component
public class MethodLogAspect extends AbstractMethodLogAspect {
}
