package com.ch09.controller;

import com.ch09.dto.User1Dto;
import com.ch09.dto.User2Dto;
import com.ch09.entity.User2;
import com.ch09.service.User2Service;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RequiredArgsConstructor

//REST API사용시
@RestController
public class User2Controller {

    private final User2Service user2Service;

    //RestController사용시 ResponsesBody 생략, 객체로 반환하면 좋음
    @GetMapping("/User2")
    public List<User2Dto> list() {
        List<User2Dto> users = user2Service.selectUser2s();
        return users;
    }

    @GetMapping("/user/{uid}")
    public User2Dto user(@PathVariable String uid) {
        User2Dto user = user2Service.selectUser2(uid);
        return user;
    }
    @PostMapping("/user2")  //ResponseEntity반환 타입이므로 동일 이름 사용가능
    public ResponseEntity register(@RequestBody User2Dto user2Dto) {
        User2 user = user2Service.insertUser2(user2Dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(user);
    }

    @PutMapping("/user2")
    public ResponseEntity modify(@RequestBody User2Dto user2DTO){
        log.info(user2DTO);
        User2 modifiedUser2 = user2Service.updateUser2(user2DTO);

        return ResponseEntity
                .status(HttpStatus.ACCEPTED) //202
                .body(modifiedUser2);
    }

    @DeleteMapping("/user2/{uid}")
    public ResponseEntity delete(@PathVariable("uid") String uid){
        try {
            user2Service.deleteUser2(uid);
            return ResponseEntity
                    .status(HttpStatus.OK) //200
                    .body("success");

        } catch (EntityNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND) //200
                    .body(e.getMessage());
        }
    }

}
