package com.ch05.dao;

import com.ch05.dto.User1DTO;
import org.apache.ibatis.annotations.Mapper;
<<<<<<< HEAD
import org.springframework.stereotype.Repository;

import java.util.List;

// mybatis scanning을 위해 @Mapper 선언
@Mapper
=======

import java.util.List;

@Mapper  //mybatis scanning을 위해 @mapper 선언
>>>>>>> 309b2fb166e05b453e73b64c702d5fe446f7bdc0
public interface User1Mapper {

    public void insertUser1(User1DTO user1DTO);
    public List<User1DTO> selectUser1s();
    public User1DTO selectUser1(String uid);
    public void updateUser1(User1DTO user1DTO);
    public void deleteUser1(String uid);
<<<<<<< HEAD

=======
>>>>>>> 309b2fb166e05b453e73b64c702d5fe446f7bdc0
}
