package com.ch05.service;

import com.ch05.dao.User3Mapper;
import com.ch05.dto.User3DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class User3Service {

    private User3Mapper user3Mapper;

    @Autowired
    public User3Service(User3Mapper user3Mapper) {
        this.user3Mapper = user3Mapper;
    }

    public void insertUser3( ) {

    }
    public void selectUse3(String uid){

    }
    public List<User3DTO> selectUser3s() {

    }
    public void updateUse3(User3DTO user3DTO) {

    }
    public void deleteUse3(String uid) {

    }
}
