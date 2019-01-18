package cn.waynechu.boot.starter.common;

import cn.waynechu.boot.starter.common.filter.MDCFilter;
import cn.waynechu.boot.starter.common.holder.DefaultDataModifiedHolder;
import cn.waynechu.boot.starter.common.holder.IDataModifiedHolder;
import cn.waynechu.boot.starter.common.interceptor.DataModifiedInterceptor;
import cn.waynechu.boot.starter.common.properties.CommonProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhuwei
 * @date 2018/12/28 16:16
 */
@Slf4j
@Configuration
@EnableConfigurationProperties({CommonProperties.class})
public class CommonAutoConfiguration {

    @Autowired
    private CommonProperties commonProperties;

    @Bean
    @ConditionalOnProperty(value = "common.mdc-filter.enable", havingValue = "true")
    @SuppressWarnings("unchecked")
    public FilterRegistrationBean mdcFilterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        MDCFilter mdcFilter = new MDCFilter();
        mdcFilter.setMdcPrefix(commonProperties.getMdcFilter().getPrefix());

        registrationBean.setFilter(mdcFilter);
        registrationBean.setOrder(1);
        return registrationBean;
    }

    @Bean
    @ConditionalOnProperty(value = "common.data-modified-interceptor.enable", havingValue = "true")
    public DataModifiedInterceptor dataModifiedInterceptor(IDataModifiedHolder dataModifiedHolder) {
        if (dataModifiedHolder == null) {
            log.warn("[DataModifiedInterceptor] Missing dataModifiedHolder bean, using defaultDataModifiedHolder. You may consider initializing one!");
            dataModifiedHolder = new DefaultDataModifiedHolder();
        }
        return new DataModifiedInterceptor(dataModifiedHolder, commonProperties.getDataModifiedInterceptor());
    }
}