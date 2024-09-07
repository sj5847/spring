package com.ch06.controller;

import com.ch06.dto.User1DTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@Log4j2
public class MainController {

    @GetMapping(value = {"/", "/index"})
    public String index(Model model) {

        String str1 = "Hello World";
        String str2 = "Hello Spring";

        //dto생성 - 생성자 초기화
        User1DTO user1 = new User1DTO("a101", "김유신", "1992-04-13", "010-1111-1111", 33);
        log.info(user1);

        //dto 생성 - 세터 초기화
        User1DTO user2 = new User1DTO();
        user1.setUid("a102");
        user1.setName("홍두깨");
        user1.setBirth("1992-01-01");
        user1.setHp("010-2222-2222");
        user1.setAge(22);

        log.info(user2);

        //dto 생성 - 빌더 초기화
        User1DTO user3 = User1DTO.builder()
                .uid("a103")
                .name("홍두식")
                .birth("1994-02-02")
                .hp("010-3333-3333")
                .age(21)
                .build();
        log.info(user3);

        List<User1DTO> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);

        model.addAttribute("str1", str1);
        model.addAttribute("str2", str2);
        model.addAttribute("user1", user1);
        model.addAttribute("user2", user2);
        model.addAttribute("user3", user3);
        model.addAttribute("users", users);

        return "index";
    }




}
