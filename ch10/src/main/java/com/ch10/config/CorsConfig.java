package com.ch10.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {  //토큰 설정

        //RESTfull 서비스를 위한 cors설정
        registry.addMapping("/**")//모든 엔드포인트에 대한 접근허용
                .allowedOriginPatterns("http://127.0.0.1/:5500", "http://localhost:5500")        //해당 도메인 origin에서의 요청 허용
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") //허용할 메서드 설정
                .allowedHeaders("*")        //모든 헤더 정보 허용
                .allowCredentials(true)     //자격증명 허용
                .maxAge(3600);              //pre-flight 요청의 유효시간 설정
    }
}
