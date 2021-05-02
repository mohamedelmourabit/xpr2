package com.xpr.sec;


import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.xpr.serializer.XprSerializerFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class  WebConfig implements WebMvcConfigurer {

    @Autowired
    XprHandlerInterceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor);
    }

  	@Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
            for(HttpMessageConverter<?> converter : converters) {
                if (converter instanceof MappingJackson2HttpMessageConverter) {
                    ((MappingJackson2HttpMessageConverter) converter).getObjectMapper().setFilterProvider(
                            new SimpleFilterProvider().addFilter("XprSerializerFilter", new XprSerializerFilter())
                    );
                }
            }
        }
    
}