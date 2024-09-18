package com.ch09.controller;

import com.ch09.dto.User1Dto;
import com.ch09.entity.User1;
import com.ch09.service.User1Service;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Controller
public class User1Controller {

    private final User1Service user1Service;

    @ResponseBody
    @GetMapping("/user1")
    public List<User1Dto> list() {
        List<User1Dto> users = user1Service.selectUser1s();
        return users;
    }

    @ResponseBody
    @GetMapping("/user1/{uid}")
    public User1Dto user(@PathVariable String uid) {
        User1Dto user = user1Service.selectUser1(uid);
        return user;
    }

    @ResponseBody
    @PostMapping("/user1")
    public ResponseEntity register(@RequestBody @Valid User1Dto user1Dto) {
        log.info(user1Dto);
        User1 savedUser1 = user1Service.insertUser1(user1Dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser1);

    }

    @PutMapping("/user1/{uid}")
    public ResponseEntity<User1> modify(@RequestBody @Valid User1Dto user1Dto, @PathVariable String uid) {
        User1 modifiedUser1 = user1Service.updateUser1(user1Dto, uid);

        //ResponseEntity로 반환할 경우 ResponseBody 생략가능
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(modifiedUser1);
    }

    @DeleteMapping("/user1/{uid}")
    public ResponseEntity<String> delete(@PathVariable String uid) {
        try {
            user1Service.deleteUser1(uid);
            return  ResponseEntity
                    .status(HttpStatus.OK)  //200
                    .body("success");
        }catch (Exception e) {
            return  ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }

    }




}
