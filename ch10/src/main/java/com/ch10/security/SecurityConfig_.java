package com.ch10.security;

import com.ch10.jwt.JwtAuthennticationFilter;
import com.ch10.jwt.JwtProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig_ {  //manager

    @Bean//어디서나 가져다 사용할 수 있음
    public SecurityFilterChain configure(HttpSecurity http, JwtProvider jwtProvider) throws Exception {
        // 토큰 기반 인증 시큐리티 설정
        http
                .csrf(AbstractHttpConfigurer::disable)          // CSRF 보안 해제
                .httpBasic(AbstractHttpConfigurer::disable)     // 기본 HTTP 인증 해제
                .formLogin(AbstractHttpConfigurer::disable)     // 폼 로그인 해제
                .sessionManagement(AbstractHttpConfigurer::disable) // 세션 해제
                .addFilterBefore(new JwtAuthennticationFilter(jwtProvider), UsernamePasswordAuthenticationFilter.class)
                //jwt 필터 등록
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/manager/**").hasAnyRole("ADMIN", "MANAGER")
                        .requestMatchers("/staff/**").hasAnyRole("ADMIN", "MANAGER", "STAFF")
                        .anyRequest().permitAll());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}