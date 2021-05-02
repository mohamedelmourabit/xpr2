package com.xpr.sec;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractMappingJacksonResponseBodyAdvice;

@RestControllerAdvice
public class XprControllerAdvice extends AbstractMappingJacksonResponseBodyAdvice {

    @Override
    protected void beforeBodyWriteInternal(
            MappingJacksonValue mappingJacksonValue,
            MediaType mediaType,
            MethodParameter methodParameter,
            ServerHttpRequest serverHttpRequest,
            ServerHttpResponse serverHttpResponse) {
        ServletServerHttpRequest request = (ServletServerHttpRequest) serverHttpRequest;

        String view = (String) request.getServletRequest().getAttribute("view");
        if (view == null || view.isEmpty())  return;
        view = view.replace(".", "$");

        try {
            mappingJacksonValue.setSerializationView(Class.forName("com.xpr.dao.core.view." + view));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
