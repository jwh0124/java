package com.cubox.server.config;

import java.util.List;

import com.cubox.server.common.utils.HTMLCharacterEscapes;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.navercorp.lucy.security.xss.servletfilter.XssEscapeServletFilter;

import org.modelmapper.ModelMapper;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // @Override
    // public void configureMessageConverters(List<HttpMessageConverter<?>>
    // converters) {
    // converters.add(escapingConverter());
    // }

    // @Bean
    // public MappingJackson2HttpMessageConverter escapingConverter() {
    // ObjectMapper objectMapper = new ObjectMapper();
    // objectMapper.getFactory().setCharacterEscapes(new HTMLCharacterEscapes());

    // MappingJackson2HttpMessageConverter escapingConverter = new
    // MappingJackson2HttpMessageConverter();
    // escapingConverter.setObjectMapper(objectMapper);

    // return escapingConverter;
    // }

    @Bean
    public FilterRegistrationBean<XssEscapeServletFilter> filterRegistrationBean() {
        FilterRegistrationBean<XssEscapeServletFilter> filterRegistration = new FilterRegistrationBean<>();
        filterRegistration.setFilter(new XssEscapeServletFilter());
        filterRegistration.setOrder(1);
        filterRegistration.addUrlPatterns("/*");

        return filterRegistration;
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    // @Bean
    // @Primary
    // public ObjectMapper objectMapper() {
    // return new
    // Jackson2ObjectMapperBuilder().featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
    // .modules(new JavaTimeModule()).timeZone("Asia/Seoul").build();
    // }
}
