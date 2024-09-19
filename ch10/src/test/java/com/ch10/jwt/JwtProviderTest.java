package com.ch10.jwt;

import com.ch10.entity.User;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JwtProviderTest {
    @Autowired
    private JwtProvider jwtProvider;


    @Test
    void createToken() {

        User user = User.builder()
                .uid("a103")
                .name("김유정")
                .birth("1990-09-09")
                .role("MANAGER")
                .build();

        String jwt = jwtProvider.createToken(user, 1);
        System.out.println("정보:"+ jwt);
    }


    @Test
    void getClaims() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJzaW1zajA0MTNAbmF2ZXIuY29tIiwiaWF0IjoxNzI2MTIzODY0LCJleHAiOjE3MjYyMTAyNjQsInVzZXJuYW1lIjoiYTEwMSIsInJvbGUiOiJBRE1JTiJ9.zvt3Dg7nEMjr9nTnOuCmZtciWen9IExWvzOef9BmpI0";
        //콘솔에 생긴 토큰 문자열 뒤에 개행문자는 지우기
        
        Claims claims = jwtProvider.getClaims(token);
        String username = (String) claims.get("username");
        String role = (String) claims.get("role");

        System.out.println(username+ role);
    }

    @Test
    void getAuthentication() {
    }

    @Test
    void validateToken(String token) throws Exception {

        try {
            jwtProvider.validateToken(token);
            System.out.println("토큰 이상 없음");
        } catch (Exception e) {
            throw new Exception(e);
        }

    }
}