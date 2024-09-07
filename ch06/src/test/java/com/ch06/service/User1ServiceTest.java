package com.ch06.service;

import com.ch06.dto.User1DTO;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class User1ServiceTest {

    @Autowired
    private User1Service user1Service;

    @Test
    @Order(1)
    void insertUser1() {
        //테스트 정의: given- when- then 패턴

        //given: 테스트를 실행하기 위한 준비
        User1DTO sample = User1DTO.builder()
                .uid("a202")
                .name("김유신")
                .birth("1999-01-02")
                .hp("010-2222-1010")
                .age(22)
                .build();
        // when : 테스트 진행
        user1Service.insertUser1(sample);

        // then : 테스트 검증(Assert 단정문을 이용해 결과 출력)
        User1DTO expected = user1Service.selectUser1(sample.getUid());
        Assertions.assertEquals(expected.toString(), sample.toString());
    }

    @Test
    @Order(3)
    void selectUser1s() {

        List<User1DTO> expected = user1Service.selectUser1s();
        Assertions.assertFalse(expected.isEmpty());  //테스트 통과
       //Assertions.assertTrue(expected.inEmpty());  //테스트 실패
    }

    @Test
    @Order(2)
    void selectUser1() {
        //given
        String uid = "a202";

        //when
        User1DTO sample = user1Service.selectUser1(uid);

        //then
        Assertions.assertEquals(sample.getUid(), uid);
    }

    @Test
    @Order(3)
    void updateUser1() {
        User1DTO sample = new User1DTO().builder()
                .uid("a202")
                .name("김유진")
                .birth("1999-01-01")
                .hp("010-1111-1111")
                .age(22)
                .build();

        user1Service.updateUser1(sample);

        User1DTO expected = user1Service.selectUser1(sample.getUid());
        Assertions.assertEquals(expected.toString(), sample.toString());
    }

    @Test
    @Order(4)
    void deleteUser1() {
        String uid = "A101";
        user1Service.deleteUser1(uid);

        User1DTO expected = user1Service.selectUser1(uid);
        Assertions.assertNull(expected);

    }
}