package com.ch05.service;

import com.ch05.dao.User1Mapper;
import com.ch05.dto.User1DTO;
<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
=======
>>>>>>> 309b2fb166e05b453e73b64c702d5fe446f7bdc0
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class User1Service {

<<<<<<< HEAD
    private final User1Mapper user1Mapper;

    @Autowired
=======
    private final User1Mapper user1Mapper;//final할 경우 생성자 필수

>>>>>>> 309b2fb166e05b453e73b64c702d5fe446f7bdc0
    public User1Service(User1Mapper user1Mapper) {
        this.user1Mapper = user1Mapper;
    }

    public void insertUser1(User1DTO user1DTO){
        user1Mapper.insertUser1(user1DTO);
    }
<<<<<<< HEAD
    public List<User1DTO> selectUser1s(){
=======
    public List<User1DTO> selectUser1s() {
>>>>>>> 309b2fb166e05b453e73b64c702d5fe446f7bdc0
        return user1Mapper.selectUser1s();
    }
    public User1DTO selectUser1(String uid){
        return user1Mapper.selectUser1(uid);
    }
    public void updateUser1(User1DTO user1DTO){
        user1Mapper.updateUser1(user1DTO);
    }
<<<<<<< HEAD
    public void deleteUser1(String uid){
        user1Mapper.deleteUser1(uid);
    }


}
=======
    public void deleteUser1(String uid) {
        user1Mapper.deleteUser1(uid);
    }
}
>>>>>>> 309b2fb166e05b453e73b64c702d5fe446f7bdc0
